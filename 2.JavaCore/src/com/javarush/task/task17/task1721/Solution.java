package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/
//c:/text1.txt
public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        allLines = Files.readAllLines(Paths.get(reader.readLine()), Charset.forName("UTF-8"));
        forRemoveLines = Files.readAllLines(Paths.get(reader.readLine()));
        reader.close();


        Solution solution = new Solution();
        try {
            solution.joinData();

        } catch (CorruptedDataException e){
            System.out.println(allLines);
            System.out.println(forRemoveLines);
        }


    }


    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
