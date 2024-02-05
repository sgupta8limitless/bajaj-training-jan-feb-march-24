package com.bajajprac.student;

import com.bajajprac.User;

public class Student extends User {

    private int rollno;
    private String subject;

    public Student(String name,int age,String city,int rollno,String subject)
    {
        super(name,age,city);
        this.rollno = rollno;
        this.subject = subject;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name,age,city"+super.toString() + '\'' +
                ", rollno=" + rollno +
                ", subject='" + subject + '\'' +
                '}';
    }


}
