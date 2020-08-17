package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
        printMatrix(1);
        printMatrix(1, 2);
        printMatrix((short)1);
        printMatrix((byte)1);
        printMatrix((short)1,(short)1);
        printMatrix((int)1,(short)1);
        printMatrix((byte)1,(byte)1);
        printMatrix((byte)1,(short)1);


    }

    public static void printMatrix (short n) {
        System.out.println("Заполняем объектами String" + n);
    }

    public static void printMatrix (byte n) {
        System.out.println("Заполняем объектами String" + n);
    }

    public static void printMatrix (int n) {
        System.out.println("Заполняем объектами String" + n);
    }



    public static void printMatrix (int n, int m) {
        System.out.println("Заполняем объектами String" + n + m);
    }

    public static void printMatrix (short n, short m) {
        System.out.println("Заполняем объектами String" + n + m);
    }

    public static void printMatrix (int n, short m) {
        System.out.println("Заполняем объектами String" + n + m);
    }

    public static void printMatrix (byte n, byte m) {
        System.out.println("Заполняем объектами String" + n + m);
    }


    public static void printMatrix (byte n, short m) {
        System.out.println("Заполняем объектами String" + n + m);
    }


    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }



    }
}
