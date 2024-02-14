package com.bajajprac;

import com.bajajprac.student.StudentController;
import com.bajajprac.student.StudentGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DBConnection dbConnection=new DBConnection();
        StudentGateway studentGateway =new StudentGateway(dbConnection);
        StudentController studentController = new StudentController(studentGateway);
        int conti;

        do {

                System.out.println("Choose The Operation");
                System.out.println("1 . Create Student");
                System.out.println("2 . Delete Student");
                System.out.println("3 . Update Student");
                System.out.println("4 . View All Student");
                System.out.println("5 . Search By Name");
                int choice = scanner.nextInt();

                switch (choice)
                {
                    case 1:
                    {
                        studentController.create();
                        break;
                    }
                    case 2:
                    {
                        studentController.delete();
                        break;
                    }
                    case 4:
                    {
                        studentController.getAll();
                        break;
                    }
                    default:
                    {
                        System.out.println("Invalid Option");
                    }
                }

                System.out.println("Do you want to continue operation 1-yes / 0-no");
                conti = scanner.nextInt();

        }while (conti==1);







//        ArrayList<Integer> n = new ArrayList();
//
//        n.add(23);
//        n.add(45);
//        n.add(26);
//
//        List<Integer> s = n.stream().filter((a)->{
//            return a%2!=0;
//        }).toList();










    }
}