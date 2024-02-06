package com.bajajprac.student;


import com.bajajprac.DBConnection;
import com.bajajprac.validators.TextValidator;
import org.w3c.dom.Text;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController implements Controller {

    Scanner scanner = new Scanner(System.in);

    StudentGateway studentGateway;

    public StudentController(StudentGateway studentGateway)
    {

        this.studentGateway = studentGateway;

    }

    @Override
    public void create()
    {
        System.out.println("enter name, age, city, rollno, subject res");
        String name = scanner.next();
        int age = scanner.nextInt();
        String city = scanner.next();
        int rollno = scanner.nextInt();
        String subject = scanner.next();

        Student student = new Student(name,age,city, rollno,subject);

        if(studentGateway.create(student)==1)
        {
            System.out.println("Student Created");
        }
        else
        {
            System.out.println("Some problem");
        }





    }

    @Override
    public void display() {





    }


}
