package com.sparta.ben.controller;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;

public class UserDAO { //Data Access Object
    private static Connection connection;
    private static Properties properties = new Properties();

    private static void createProperties(){
        try {
            properties.load(new FileReader("src/main/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void connectToDB(String url) {
        createProperties();
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Connected to Database");
    }
    public static void queryDatabase(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_database.employees");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insertData(String employeeID, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, LocalDate dob, LocalDate dateOfJoining, int salary){
        try {
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(
                                        "INSERT INTO `employee_database` . `employees` " +
                            "(`employee_id`, `name_prefix`, `first_name`, `middle_initial`, `last_name`, `gender`, `email`, `dob`, `date_of_joining`, `salary` ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, employeeID);
            preparedStatement.setString(2, namePrefix);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, middleInitial);
            preparedStatement.setString(5, lastName);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, email);
            preparedStatement.setDate(8, java.sql.Date.valueOf(dob));
            preparedStatement.setDate(9, java.sql.Date.valueOf(dateOfJoining));
            preparedStatement.setInt(10, salary);
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
