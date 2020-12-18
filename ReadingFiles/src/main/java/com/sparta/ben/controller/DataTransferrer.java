package com.sparta.ben.controller;

import com.sparta.ben.model.EmployeeDTO;

import java.util.ArrayList;

public class DataTransferrer implements Runnable {

    public void run(){

        long start = System.nanoTime();
        ArrayList<EmployeeDTO> employeeListLarge = CSVReader.readEmployees("src/main/resources/EmployeeRecordsLarge.csv");
        long end = System.nanoTime();
        System.out.println("Time taken to read file: " + (end - start)/1000000 +  " milliseconds");
        System.out.println("\n");
        System.out.println("Checking for duplicate values...");
        DuplicateChecker.uniqueList(employeeListLarge);

        long transferStart = System.nanoTime();
        String url = "jdbc:mysql://localhost:3306/employee_database?serverTimezone=GMT";
        UserDAO.connectToDB(url);
        DuplicateChecker.employeeListAdder(employeeListLarge);
        long transferEnd = System.nanoTime();
        System.out.println("Time taken to transfer: " + (transferEnd - transferStart)/1000000000 +  " seconds");
    }
}
