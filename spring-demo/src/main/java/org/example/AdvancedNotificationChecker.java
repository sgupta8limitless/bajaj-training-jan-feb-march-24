package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope("prototype")
public class AdvancedNotificationChecker implements NotificationChecker {

    public boolean check(String msg)
    {
        System.out.println("advanced checking done");

        if(msg!="" && msg.length()>10)
        {

            return true;
        }

        return false;
    }

}
