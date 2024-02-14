package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


//        BasicNotificationChecker basicnotificationChecker = new BasicNotificationChecker();
//        AdvancedNotificationChecker advancedNotificationChecker = new AdvancedNotificationChecker();
//        NoticationClient noticationClient = new NoticationClient(basicnotificationChecker);
//
//        noticationClient.send();


//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("spring-config.xml");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig2.class);
//
//        NotificationClient notificationClient
//                = context.getBean("notificationClient",NotificationClient.class);
//
//        notificationClient.send();




//        for checking scope

        AdvancedNotificationChecker advancedNotificationChecker
                = context.getBean("advancedNotificationChecker",AdvancedNotificationChecker.class);


        System.out.println(advancedNotificationChecker);


        AdvancedNotificationChecker advancedNotificationChecker1
                = context.getBean("advancedNotificationChecker",AdvancedNotificationChecker.class);


        System.out.println(advancedNotificationChecker1);

        int a;

//        System.out.println();
//
//





    }
}