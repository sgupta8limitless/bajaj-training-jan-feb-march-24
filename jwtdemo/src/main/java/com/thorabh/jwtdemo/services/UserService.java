package com.thorabh.jwtdemo.services;

import com.thorabh.jwtdemo.models.CustomUserDetails;
import com.thorabh.jwtdemo.models.User;
import com.thorabh.jwtdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User create(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByUsername(username);

        if(userOptional.isEmpty())
        {
            throw new UsernameNotFoundException("User Doesnt Exist!!!");
        }

        return new CustomUserDetails(userOptional.get());
    }
}
