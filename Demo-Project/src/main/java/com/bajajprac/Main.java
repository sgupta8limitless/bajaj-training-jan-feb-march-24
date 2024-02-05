package com.bajajprac;


import com.bajajprac.student.Controller;
import com.bajajprac.student.StudentController;
import com.bajajprac.validators.NameValidator;
import com.bajajprac.validators.TextValidator;

public class Main {

    public static void main(String[] args) {


        TextValidator nameValidator= new NameValidator();

        Controller studentController = new StudentController(nameValidator);

        studentController.create();
        studentController.display();









    }
}