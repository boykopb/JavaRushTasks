package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());


    }


    public static void main(String[] args) {

    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }

    }

    public static class Thread2 extends Thread {

        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(10000);

            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }


    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Ура");
                    Thread.currentThread().sleep(500);

                }
            } catch (InterruptedException e) {
            }

        }

    }

    public static class Thread4 extends Thread implements Message {
        @Override
        public void run() {
            while (!this.isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();

        }
    }

    public static class Thread5 extends Thread {


        @Override
        public void run() {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<Integer> sum = new ArrayList<>();
            int totalSum = 0;
            String s = "";
            while (true) {
                try {
                    s = read.readLine();
                    sum.add(Integer.parseInt(s));

                } catch (NumberFormatException | IOException e) {
                    if (s.equals("N")) {
                        try {
                            read.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;
                    }
                }


            }
            for (Integer n : sum) totalSum += n;

            System.out.println(totalSum);


        }

    }


}