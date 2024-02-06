package com.bajajprac.student;

import com.bajajprac.User;

public class Student  {

    private String name;
    private int age;

    private String city;
    private int rollno;
    private String subject;


    public Student(String name, int age, String city, int rollno, String subject) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.rollno = rollno;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", rollno=" + rollno +
                ", subject='" + subject + '\'' +
                '}';
    }
}
