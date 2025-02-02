package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution(4);
        System.out.println(solution);


        String fileOutput = "c:/2.txt";
        String input = "c:/2.txt";

        FileOutputStream fos = new FileOutputStream(fileOutput);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(solution);
        fos.close();
        oos.close();


        FileInputStream fis = new FileInputStream(input);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object object = ois.readObject();
        fis.close();
        ois.close();

        Solution loadedObject = (Solution) object;


        System.out.println(loadedObject.string);
        System.out.println(loadedObject.currentDate);
        System.out.println(loadedObject.temperature);

    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }


}
