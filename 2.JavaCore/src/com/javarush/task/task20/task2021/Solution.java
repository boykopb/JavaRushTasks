package com.javarush.task.task20.task2021;

import java.io.*;

/*
Сериализация под запретом
*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        private void writeObject(ObjectOutputStream out) throws IOException {
            throw new NotSerializableException("Don't want to serialize this object");
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new NotSerializableException("Don't want to serialize this object");
        }
    }

    public static void main(String[] args) {

    }
}
