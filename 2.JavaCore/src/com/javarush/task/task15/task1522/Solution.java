package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String s = buff.readLine();
        if (s.equals(Planet.SUN)) {
            thePlanet = Sun.getInstance();
        }
        if (s.equals(Planet.MOON)) {
            thePlanet = Moon.getInstance();
        }
        if (s.equals(Planet.EARTH)) {
            thePlanet = Earth.getInstance();
        }
        if (!((s.equals(Planet.EARTH)) || (s.equals(Planet.MOON)) || (s.equals(Planet.SUN)))){
            thePlanet = null;
        }


    }

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
