package com.bajajprac.student;


import com.bajajprac.validators.TextValidator;
import org.w3c.dom.Text;

import javax.swing.*;
import java.util.Scanner;

public class StudentController implements Controller {

    Scanner scanner = new Scanner(System.in);
    TextValidator nameValidator;
    Student student;


    public StudentController(TextValidator nameValidator)
    {
        this.nameValidator = nameValidator;
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

        if(nameValidator.validate(name)==true)
        {
            student = new Student(name,age,city, rollno,subject);
        }


    }

    @Override
    public void display() {

        System.out.println(student);

    }


}
