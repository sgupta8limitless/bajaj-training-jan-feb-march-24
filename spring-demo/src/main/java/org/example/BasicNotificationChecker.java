package org.example;

import org.springframework.stereotype.Component;

@Component
public class BasicNotificationChecker implements NotificationChecker {

    public boolean check(String msg)
    {
        System.out.println("basic checking done");

        if(msg!="")
        {

            return true;
        }

        return false;
    }

}
