package com.javarush.task.task30.task3008;

import com.javarush.task.task30.task3008.client.Client;

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

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String userName;
            Message request = new Message(MessageType.NAME_REQUEST);
            Message answer;
            do {
                connection.send(request);
                answer = connection.receive();
                userName = answer.getData();
            }
            while (answer.getType() != MessageType.USER_NAME || userName.isEmpty() || connectionMap.containsKey(userName));
            connectionMap.put(userName, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED, " присоединился к чату"));
            return userName;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
                if (!userName.equals(map.getKey())) {
                    connection.send(new Message(MessageType.USER_ADDED, map.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while(true) {
                Message chatting = connection.receive();
                if (chatting.getType() == MessageType.TEXT) {
                    Server.sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + chatting.getData()));
                }
                if (chatting.getType() != MessageType.TEXT) {
                    ConsoleHelper.writeMessage("Ошибка в методе serverMainLoop класса Server.Handler." +
                            " Тип сообщения не \"TEXT\". Отправка не возможна.");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с сервером: " + socket.getRemoteSocketAddress());
            String userName;
            try (Connection connection = new Connection(socket)) {
                userName =serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка в методе run класса Server.Handler." +
                        " Ошибка при обмене данными с удаленным адресом.");
            }


        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");

            while (true) {
                Socket newSocket = serverSocket.accept();
                Handler handler = new Handler(newSocket);
                handler.start();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }


        Client client = new Client();
        client.run();

    }


    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
            try {
                map.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Ошибка в методе sendBroadcastMessage класса Server. " +
                        "Не могу отправить сообщение пользователю: " + map.getKey());
            }
        }
    }
}
