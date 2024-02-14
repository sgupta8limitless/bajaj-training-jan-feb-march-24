package com.bajajprac.student;

import com.bajajprac.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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


    public int delete(int id)
    {
        String query = "delete from students where id = ?";

        try {

            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1,id);

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Student> get()
    {
        String query = "select * from students";
        ArrayList<Student> students = new ArrayList();

        try {

            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.isBeforeFirst())
            {

                while (resultSet.next())
                {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setAge(resultSet.getInt("age"));
                    student.setRollno(resultSet.getInt("rollno"));
                    student.setCity(resultSet.getString("city"));
                    student.setSubject(resultSet.getString("subject"));

                    students.add(student);

                }

                return students;
            }

            return null;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }



}
