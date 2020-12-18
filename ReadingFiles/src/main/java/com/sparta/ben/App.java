package com.sparta.ben;



import com.sparta.ben.controller.DataTransferrer;
import com.sparta.ben.controller.UserDAO;

public class App {
    public static void main(String[] args) {





        long start = System.nanoTime();

        Thread thread = new Thread(new DataTransferrer());
        thread.start();
        System.out.println(Thread.currentThread().getName());

        while (thread.isAlive()){}

        long end = System.nanoTime();
        System.out.println("Time taken to finish " + (end - start)/1000000000 +  " seconds");

    }
}
