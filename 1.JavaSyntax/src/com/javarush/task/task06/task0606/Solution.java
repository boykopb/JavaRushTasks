package com.javarush.task.task06.task0606;

/* 
Чётные и нечётные циферки
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(buff.readLine());

        while (a>0){
            int tempA = a%10;
            if (tempA%2==0) {
                even++;
            }
            if (tempA%2!=0) {
                odd++;
            }
            a/=10;

        }
        System.out.printf("Even: %d Odd: %d", even, odd);

    }
}
