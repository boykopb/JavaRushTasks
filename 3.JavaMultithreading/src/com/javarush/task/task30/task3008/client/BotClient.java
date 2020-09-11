package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.split(":").length == 2) {
                String command = message.substring(message.indexOf(":") + 2);
                SimpleDateFormat dateFormat;
                switch (command) {
                    case ("дата"):
                        dateFormat = new SimpleDateFormat("d.MM.yyyy");
                        break;
                    case ("день"):
                        dateFormat = new SimpleDateFormat("d");
                        break;
                    case ("месяц"):
                        dateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case ("год"):
                        dateFormat = new SimpleDateFormat("yyyy");
                        break;
                    case ("время"):
                        dateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case ("час"):
                        dateFormat = new SimpleDateFormat("H");
                        break;
                    case ("минуты"):
                        dateFormat = new SimpleDateFormat("mm");
                        break;
                    case ("секунды"):
                        dateFormat = new SimpleDateFormat("s");
                        break;
                    default:
                        dateFormat = null;

                }

                if (dateFormat != null) {
                    String userName = message.substring(0, message.lastIndexOf(":"));
                    Calendar calendar = new GregorianCalendar();
                    try {
                        sendTextMessage("Информация для " + userName + ": " + dateFormat.format(calendar.getTime()));
                    } catch (IOException ignored) {
                    }
                }
            }
        }
    } //end of BotSocketThread

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();

    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int random = (int) (Math.random() * 100);
        return String.format("date_bot_%d", random);

    }

    public static void main(String[] args) throws IOException {
        BotClient botClient = new BotClient();
        botClient.run();
    }


}
