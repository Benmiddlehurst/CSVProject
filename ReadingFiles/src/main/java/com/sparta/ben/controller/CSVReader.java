package com.sparta.ben.controller;

import com.sparta.ben.model.EmployeeDTO;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    public static ArrayList<EmployeeDTO> readEmployees(String path) {
        ArrayList<EmployeeDTO> employees = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                EmployeeDTO employeeDTO = new EmployeeDTO(
                        temp[0],
                        temp[1],
                        temp[2],
                        temp[3],
                        temp[4],
                        temp[5],
                        temp[6],
                        temp[7],
                        temp[8],
                        temp[9]);
                employees.add(employeeDTO);

            } bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            System.out.println("Files found: "+employees.size());
        return employees;
    }
}

