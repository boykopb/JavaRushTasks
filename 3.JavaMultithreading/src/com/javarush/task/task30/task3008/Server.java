package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void main(String[] args) throws IOException {
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started");

            while (true) {
                Socket newSocket = serverSocket.accept();
                Handler handler = new Handler(newSocket);
                handler.start();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }


    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
            try {
                map.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Can't send message to : " + map.getKey());
            }
        }
    }
}
