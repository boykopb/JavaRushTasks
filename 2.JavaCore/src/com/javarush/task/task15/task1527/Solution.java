package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/
//http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
//http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
//http://javarush.ru/alpha/index.html?obj=ы.&name=Amigo
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String s = buff.readLine();
        buff.close();
        s = s.substring(s.indexOf("?")+1);                                       //выбрасываем все до "?"
        String[] s1 = s.split("&");                                        //делаем массив (сплит по "&")
        String number = "";
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].contains("=")) {                                          //сплиттим по знаку "="
                if (s1[i].contains("obj")) {
                    number =s1[i].substring(s1[i].indexOf("=")+1);              //сразу же делаем "число"
                }
                System.out.print(s1[i].substring(0, s1[i].indexOf("=")) + " "); //выводим параметры, где есть "=".
            } else{
                System.out.print(s1[i] + " ");                                  //выводим параметры, где нет "="
            }
        }
        System.out.println();
        if (!number.isEmpty()) {
            try {
                alert(Double.parseDouble(number));
            } catch (NumberFormatException e) {
                alert(number);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
