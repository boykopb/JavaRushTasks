package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        askOperation();
      /*  BufferedReader keyboardreader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь к результату архивации");
        String archivePath = keyboardreader.readLine();

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(archivePath));

        System.out.println("Введите полный путь к файлу, который будем архивировать");
        String filePath = keyboardreader.readLine();

        keyboardreader.close();

        zipFileManager.createZip(Paths.get(filePath));

        ExitCommand exitCommand = new ExitCommand();

        exitCommand.execute();*/
    }

    public static Operation askOperation() throws IOException {
        for(Operation operation : Operation.values())
            ConsoleHelper.writeMessage(String.format("%s - %s", operation.ordinal(), operation));

        Operation operationResult;
        switch (ConsoleHelper.readInt()) {
            case 0:
                operationResult = Operation.CREATE;
                break;
            case 1:
                operationResult = Operation.ADD;
                break;
            case 2:
                operationResult = Operation.REMOVE;
                break;
            case 3:
                operationResult = Operation.EXTRACT;
                break;
            case 4:
                operationResult = Operation.CONTENT;
                break;
            default:
                operationResult = Operation.EXIT;
                break;
        }
        return operationResult;
    }
}
