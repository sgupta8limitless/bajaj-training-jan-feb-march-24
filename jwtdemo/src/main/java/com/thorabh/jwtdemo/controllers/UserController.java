package com.thorabh.jwtdemo.controllers;

import com.thorabh.jwtdemo.models.AuthRequest;
import com.thorabh.jwtdemo.models.User;
import com.thorabh.jwtdemo.services.JwtService;
import com.thorabh.jwtdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;



    @PostMapping("/register")
    public User create(@RequestBody User user)
    {
        return userService.create(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest)
    {
        Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
        );

        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(authRequest.getUsername());
        }
        else
        {
            return "Something wrong";
        }
    }


    @GetMapping("/protected")
    public String test()
    {
        return "All good with token";
    }






}

