package com.bajajprac.student;

import com.bajajprac.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentGateway {

    private DBConnection dbConnection;

    public StudentGateway(DBConnection dbConnection)
    {
        this.dbConnection=dbConnection;
    }
    public int create(Student student)
    {
        String query = "insert into students(name,age,rollno,city,subject) values (?,?,?,?,?)";
        try {

            PreparedStatement preparedStatement=dbConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setInt(3,student.getRollno());
            preparedStatement.setString(4,student.getCity());
            preparedStatement.setString(5,student.getSubject());

            return preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
