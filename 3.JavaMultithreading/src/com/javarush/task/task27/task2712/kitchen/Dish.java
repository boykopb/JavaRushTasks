package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        String result = "";

        for (Dish dish : Dish.values()) {
            if ("".equals(result)) {
                result += dish.name();
            } else {
                result += ", " + dish.name();
            }
        }
        return result;
    }
}
