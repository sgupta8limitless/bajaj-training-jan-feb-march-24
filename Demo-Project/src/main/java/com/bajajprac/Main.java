package com.bajajprac;

import com.bajajprac.student.Controller;
import com.bajajprac.student.StudentController;
import com.bajajprac.student.StudentGateway;
import com.bajajprac.validators.NameValidator;
import com.bajajprac.validators.TextValidator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {



        DBConnection dbConnection=new DBConnection();

        StudentGateway studentGateway =new StudentGateway(dbConnection);

        StudentController studentController = new StudentController(studentGateway);

        studentController.create();



    }
}