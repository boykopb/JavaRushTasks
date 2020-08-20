package com.javarush.task.task20.task2022;


import java.io.*;
/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {

        Solution sol = new Solution("C:/1.txt");
        sol.writeObject("Wright1");
        sol.writeObject("Wright12");
        sol.writeObject("Wright13");


        String filePath = "C:/2.txt";
        ObjectOutputStream streamOut = new ObjectOutputStream(new FileOutputStream(filePath));
        //если попытаться тут у объекта запустить метод writeObject(ObjectOutputStream out) и
        //передать туда наш стрим - получим ошибку NotActiveException - это не правильно.
        streamOut.writeObject(sol);
        //закрываем поток вывода в файл
        sol.close();
        //закрываем поток сериализации
        streamOut.close();

        ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream(filePath));
        Solution sol2 = (Solution) streamIn.readObject();
        sol2.writeObject("newStream1");
        sol2.writeObject("newStream2");
        sol2.writeObject("newStream3");

        //закрываем поток вывода в файл
        sol2.close();
        //закрываем поток десериализации
        streamIn.close();

    }
}
