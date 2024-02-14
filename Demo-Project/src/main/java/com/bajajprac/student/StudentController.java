package com.bajajprac.student;


import com.bajajprac.DBConnection;
import com.bajajprac.validators.TextValidator;
import org.w3c.dom.Text;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

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

    public void getAll()
    {
        ArrayList<Student> students = studentGateway.get();
        this.display(students);
    }


    public void display(ArrayList<Student> students) {

        AtomicInteger counter = new AtomicInteger(1);

        students.forEach((student -> {
            System.out.println(counter+" "+student.getName()+" "+student.getRollno()+" "+student.getCity());
            counter.getAndIncrement();
        }));


    }

    @Override
    public void delete() {

        ArrayList<Student> students = studentGateway.get();
        this.display(students);

        System.out.println("Choose Serial No to Delete");
        int sro = scanner.nextInt();

        Student student = students.get(sro-1);

        if(studentGateway.delete(student.getId())==1)
        {
            System.out.println("Student Deleted");
        }
        else
        {
            System.out.println("Some Problem");
        }

    }


}
