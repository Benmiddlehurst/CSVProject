package com.sparta.ben;

import com.sparta.ben.controller.CSVReader;
import com.sparta.ben.controller.DuplicateChecker;
import com.sparta.ben.controller.UserDAO;
import com.sparta.ben.model.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;

public class Tester {
    @Test
    void hasTheCSVFileBeenRead(){
        String path = "src/main/resources/EmployeeRecordsLarge.csv";
        ArrayList<EmployeeDTO> readList = CSVReader.readEmployees(path);
        Assertions.assertTrue(readList.size() > 0);
    }
    @Test
    void areDuplicatesRemoved() {
        String path = "src/main/resources/EmployeeRecordsLarge.csv";
        ArrayList<EmployeeDTO> readList = CSVReader.readEmployees(path);
        if (((DuplicateChecker.duplicateEmail(readList).size()) | DuplicateChecker.duplicateEmployeeID(readList).size()) > 0) {
            Assertions.assertTrue(readList.size() > DuplicateChecker.uniqueList(readList).size(), "Duplicates have been removed");
        }
    }
    @Test
    void hasDataBeenTransferred(){
        String path = "src/main/resources/EmployeeRecordsLarge.csv";
        ArrayList<EmployeeDTO> readList = CSVReader.readEmployees(path);
        DuplicateChecker.uniqueList(readList);
        String url = "jdbc:mysql://localhost:3306/employee_database?serverTimezone=GMT";
        Statement statement = null;
        UserDAO.connectToDB(url);
        DuplicateChecker.employeeListAdder(readList);
        HashSet<String> transferredData = new HashSet<>();
        ArrayList<String> employeeIDChecker = new ArrayList<>();
        Connection connection;
        Properties properties = new Properties();
        boolean isDataTheSame = false;
         try {
             properties.load(new FileReader("src/main/resources/login.properties"));
            String userName = properties.getProperty("userName");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_database.employees");
            
            while (resultSet.next()) {
                transferredData.add(resultSet.getString(1));
            }
             System.out.println(transferredData.size());
            int i = 0;
            for (EmployeeDTO e : readList){
                if (transferredData.contains(e.getEmployeeID())){
                    isDataTheSame = true;
                } else {isDataTheSame = false;
                break;}
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }Assertions.assertTrue(isDataTheSame);
    }
}
