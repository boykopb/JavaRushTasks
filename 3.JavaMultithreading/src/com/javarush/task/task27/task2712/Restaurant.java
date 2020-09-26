package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;

public class Restaurant {

    public static void main(String[] args) throws IOException {
        Tablet tablet = new Tablet(1);
        Cook cook = new Cook("John Smith");
        tablet.addObserver(cook);
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
    }
}
