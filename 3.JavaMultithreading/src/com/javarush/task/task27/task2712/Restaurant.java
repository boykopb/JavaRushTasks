package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;
import java.util.ArrayList;

public class Restaurant {

    public static void main(String[] args) throws IOException {
        Waiter waiter = new Waiter();
        Cook cook = new Cook("John Smith");

        Tablet tablet = new Tablet(1);
        cook.addObserver(waiter);

        tablet.addObserver(cook);

        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
    }
}
