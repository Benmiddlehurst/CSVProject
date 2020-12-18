package com.sparta.ben.controller;


import com.sparta.ben.model.EmployeeDTO;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DuplicateChecker {
//    public static ArrayList<EmployeeDTO> duplicateChecker(ArrayList<EmployeeDTO> readList) {
//        ArrayList<EmployeeDTO> duplicateList = new ArrayList<>();
//        ArrayList<Integer> duplicateIndex = new ArrayList<>();
//        int i = 0;
//        while (i < readList.size()) {
//            for (EmployeeDTO e : readList) {
//                if (((readList.get(i).getEmployeeID().equals(e.getEmployeeID())) && (!readList.get(i).equals(e)))) {
//                    duplicateList.add(e);
//                    duplicateIndex.add(i);
//                } else {
//                }
//            }
//            i++;
//        }
//           // System.out.println(duplicateList.toString());
//            System.out.println("Duplicate EmployeeIDs found:" + duplicateList.size());
//            return duplicateList;
//    }
//
//    public static ArrayList<EmployeeDTO> tempList(ArrayList<EmployeeDTO> readList){
//        ArrayList<EmployeeDTO> tempList = new ArrayList<>();
//        tempList = readList;
//        return tempList;
//    }
//
//    public static ArrayList<Integer> duplicateIndex(ArrayList<EmployeeDTO> readList) {
//        ArrayList<Integer> duplicateIndex = new ArrayList<>();
//                int i = 0;
//        while (i < readList.size()) {
//            for (EmployeeDTO e : readList) {
//                if (((readList.get(i).getEmployeeID().equals(e.getEmployeeID())) && (!readList.get(i).equals(e)))) {
//                    duplicateIndex.add(i);
//                } else {
//                }
//            }
//            i++;
//        }
//      //  System.out.println("Duplicates Index:" + duplicateIndex.toString());
//        return duplicateIndex;
//    }
//
//    public static ArrayList<EmployeeDTO> duplicateRemover(ArrayList<EmployeeDTO> readList) {
//        ArrayList<EmployeeDTO> uniqueIDlist;
//        uniqueIDlist = readList;
//        ArrayList<EmployeeDTO> duplicateList = duplicateChecker(readList);
//        int duplicateCount = 0;
//        for (EmployeeDTO em : duplicateList) {
//            duplicateCount++;
//            uniqueIDlist.remove(em);
//
//        }
//        System.out.println("Duplicate EmployeeIDs Removed:" + duplicateCount);
//        System.out.println("Unique files remaining:" + uniqueIDlist.size());
//        return uniqueIDlist;
//    }
//
//    public static void employeeListAdder(ArrayList<EmployeeDTO> uniqueList){
//        System.out.println("Beginning transfer.");
////        int percentTracker = 0;
////        int percentDisplay = 0;
//        for(EmployeeDTO e : uniqueList) {
////            percentTracker++;
////            if (percentTracker/uniqueList.size() >= 0.50){
////                percentDisplay += 50;
////                percentTracker = 0;
////                System.out.println("Transfer is " +percentDisplay+ "% complete");
////            }
//            UserDAO.insertData(e.getEmployeeID(), e.getNamePrefix(), e.getFirstName(), e.getMiddleInitial(), e.getLastName(),
//                    e.getGender(), e.getEmail(), e.getDob(), e.getDateOfJoining(), e.getSalary());
//        }
//
//    }

//    public static ArrayList<EmployeeDTO> duplicateFinder(ArrayList<EmployeeDTO> readList){
//        ArrayList<EmployeeDTO> duplicateList = new ArrayList<>();
//        int i = 0;
//        while (i < readList.size()){
//            for (EmployeeDTO e : readList){
//                if(readList.get(i).getEmployeeID().equals(e.getEmployeeID()) && (!readList.get(i).equals(e))){
//                    duplicateList.add(e);
//                } else {}
//            }
//            i++;
//        }
//        System.out.println(duplicateList.toString());
//        return duplicateList;
//    }
// ---------------------------ArrayList-----------------------------------------------
//public static ArrayList<EmployeeDTO> duplicateChecker(ArrayList<EmployeeDTO> readList) {
//        HashSet<EmployeeDTO> duplicateList = new HashSet<>();
//        ArrayList<EmployeeDTO> duplicatedList = new ArrayList<>();
////        ArrayList<Integer> duplicateIndex = new ArrayList<>();
//        int i = 0;
//        long start = System.nanoTime();
//        while (i < readList.size()) {
//            for (EmployeeDTO e : readList) {
//                if (((readList.get(i).getEmployeeID().equals(e.getEmployeeID())) && (!readList.get(i).equals(e)))) {
//                    duplicateList.add(e);
////                    duplicateIndex.add(i);
//                } else {
//                }
//            }
//            i++;
//        }
//           // System.out.println(duplicateList.toString());
//            long end = System.nanoTime();
//            System.out.println("Time taken to find duplicates: "+ (end - start)/1000000000 +" seconds");
//            System.out.println("Duplicate EmployeeIDs found:" + duplicateList.size());
//            duplicatedList = duplicateList;
//            return duplicatedList;
//    }

//    public static HashMap<String, Integer> duplicateEmployeeIDIndex(ArrayList<EmployeeDTO> readList){
//        HashMap<String, Integer> duplicateEmployeeIDIndex = new HashMap<>();
//        Integer i = 0;
//        for (EmployeeDTO e: readList){
//            i = duplicateEmployeeIDIndex.get(e);
//            if(i == null){
//                duplicateEmployeeIDIndex.put(e.getEmployeeID(), 1);
//            } else {
//                duplicateEmployeeIDIndex.put(e.getEmployeeID(), i++);
//            }
//        }
//
//
//        System.out.println(duplicateEmployeeIDIndex.size());
//        System.out.println(duplicateEmployeeIDIndex.toString());
//        return duplicateEmployeeIDIndex;
//    }

//    int readListSize;
//    int duplicateListSize;
//    int uniqueListSize;
//
//    public int getReadListSize() {
//        return readListSize;
//    }
//
//    public void setReadListSize(int readListSize) {
//        this.readListSize = readListSize;
//    }
//
//    public int getDuplicateListSize() {
//        return duplicateListSize;
//    }
//
//    public void setDuplicateListSize(int duplicateListSize) {
//        this.duplicateListSize = DuplicateChecker.duplicateEmail().size();
//    }
//
//    public int getUniqueListSize() {
//        return uniqueListSize;
//    }
//
//    public void setUniqueListSize(int uniqueListSize) {
//        this.uniqueListSize = uniqueListSize;
//    }


    public static ArrayList<EmployeeDTO> duplicateEmployeeID(ArrayList<EmployeeDTO> readList) {
        HashSet<String> duplicateList = new HashSet<>();
        HashSet<String> tempList = new HashSet<>();
        ArrayList<EmployeeDTO> duplicateIDs = new ArrayList<>();
        long start = System.nanoTime();
        System.out.println("Searching for duplicate employeeIDs...");
        for (EmployeeDTO e : readList) {
            if (!tempList.contains(e.getEmployeeID())) {
                tempList.add(e.getEmployeeID());
            } else{
                duplicateList.add(e.getEmployeeID());
            }
        }
        for (EmployeeDTO e : readList){
            if (tempList.contains(e.getEmployeeID()) && duplicateList.contains(e.getEmployeeID())){
                duplicateIDs.add(e);
            }
        } tempList.removeAll(duplicateList);
        long end = System.nanoTime();
        System.out.println("Time taken to search for duplicates: "+ (end - start)/1000000 +" milliseconds");
        System.out.println("Duplicate EmployeeIDs found: " + duplicateIDs.size());
        System.out.println("\n");
        return duplicateIDs;
    }

    public static ArrayList<EmployeeDTO> duplicateEmail(ArrayList<EmployeeDTO> readList) {
        HashSet<String> duplicateList = new HashSet<>();
        HashSet<String> tempList = new HashSet<>();
        ArrayList<EmployeeDTO> duplicateEmail = new ArrayList<>();
        long start = System.nanoTime();
        System.out.println("Searching for duplicate emails...");
        for (EmployeeDTO e : readList) {
            if (!tempList.contains(e.getEmail())) {
                tempList.add(e.getEmail());
            } else{
                duplicateList.add(e.getEmail());
            }
        }
        for (EmployeeDTO e : readList){
            if (tempList.contains(e.getEmail()) && duplicateList.contains(e.getEmail())){
                duplicateEmail.add(e);
            }
        } tempList.removeAll(duplicateList);
        long end = System.nanoTime();
        System.out.println("Time taken to search for duplicates: "+ (end - start)/1000000 +" milliseconds");
        System.out.println("Duplicate Emails found: " + duplicateEmail.size());
        System.out.println("\n");
        return duplicateEmail;
    }


    public static ArrayList<EmployeeDTO> uniqueList(ArrayList<EmployeeDTO> readlist){
        ArrayList<EmployeeDTO> uniqueList = new ArrayList<>();
        ArrayList<EmployeeDTO> duplicateEmployeeIDs = duplicateEmployeeID(readlist);
        ArrayList<EmployeeDTO> duplicateEmails = duplicateEmail(readlist);
        long start = System.nanoTime();
        for (EmployeeDTO e : readlist){
            if((!duplicateEmployeeIDs.contains(e)) && (!duplicateEmails.contains(e))) {
                uniqueList.add(e);
            }
        }
        long end = System.nanoTime();
        System.out.println("Removing duplicates...");
        System.out.println("Duplicates removed: "+ (duplicateEmployeeIDs.size() + duplicateEmails.size()));
        System.out.println("Time taken to remove duplicates: " + (end - start)/1000000 + " milliseconds");
        System.out.println("\n");
        return uniqueList;
    }

//    public static HashSet<EmployeeDTO> duplicateCheckerEmail(ArrayList<EmployeeDTO> readList) {
//        HashSet duplicateEmail = new HashSet();
//        ArrayList<EmployeeDTO> tempList = readList;
//        int employeeEmailCount = 0;
//        long start = System.nanoTime();
//        for (EmployeeDTO e : readList){
//            if (tempList.contains(e.getEmail())){
//                employeeEmailCount++;
//                if (employeeEmailCount > 1){
//                    duplicateEmail.add(e);
//                    employeeEmailCount = 0;
//                }
//            }
//        }
//        long end = System.nanoTime();
//        System.out.println("Time taken to search for duplicates: "+ (end - start)/1000000000 +" seconds");
//        System.out.println("Duplicate Emails found:" + duplicateEmail.size());
//        return duplicateEmail;
//    }

//    public static ArrayList<EmployeeDTO> tempList(ArrayList<EmployeeDTO> readList){
//        ArrayList<EmployeeDTO> tempList = new ArrayList<>();
//        tempList = readList;
//        return tempList;
//    }

//    public static ArrayList<Integer> duplicateIndex(ArrayList<EmployeeDTO> readList) {
//        ArrayList<Integer> duplicateIndex = new ArrayList<>();
//                int i = 0;
//        while (i < readList.size()) {
//            for (EmployeeDTO e : readList) {
//                if (((readList.get(i).getEmployeeID().equals(e.getEmployeeID())) && (!readList.get(i).equals(e)))) {
//                    duplicateIndex.add(i);
//                } else {
//                }
//            }
//            i++;
//        }
//      //  System.out.println("Duplicates Index:" + duplicateIndex.toString());
//        return duplicateIndex;
//    }

//    public static ArrayList<EmployeeDTO> duplicateRemover(ArrayList<EmployeeDTO> readList) {
//        ArrayList<EmployeeDTO> uniqueIDlist;
//        uniqueIDlist = readList;
//        HashSet<String> duplicateEmployeeID = duplicateEmployeeID(readList);
////        HashSet<EmployeeDTO> duplicateEmail = duplicateCheckerEmail(readList);
//
//        int duplicateEmployeeIDCount = 0;
//        int duplicateEmailCount = 0;
//        long start = System.nanoTime();
//        for (String em : duplicateEmployeeID) {
//            duplicateEmployeeIDCount++;
//            uniqueIDlist.remove(em);
//        }
//        for (EmployeeDTO em : duplicateEmail) {
//            duplicateEmailCount++;
//            uniqueIDlist.remove(em);
//        }
//        long end = System.nanoTime();
//        System.out.println("Time taken to remove duplicates: "+ (end - start)/1000000 + " milliseconds.");
//        System.out.println("Duplicate EmployeeIDs Removed:" + duplicateEmployeeIDCount);
//        System.out.println("Duplicate Emails Removed:" + duplicateEmailCount);
//        System.out.println("Unique files remaining:" + uniqueIDlist.size());
//        return uniqueIDlist;
//    }

    public static void employeeListAdder(ArrayList<EmployeeDTO> uniqueList){
        System.out.println("Beginning transfer...");
        for(EmployeeDTO e : uniqueList) {
            UserDAO.insertData(e.getEmployeeID(), e.getNamePrefix(), e.getFirstName(), e.getMiddleInitial(), e.getLastName(),
                    e.getGender(), e.getEmail(), e.getDob(), e.getDateOfJoining(), e.getSalary());
        }

    }


}

