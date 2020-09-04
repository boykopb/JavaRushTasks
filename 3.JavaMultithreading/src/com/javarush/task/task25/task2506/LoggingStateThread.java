package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread target;

    public LoggingStateThread(Thread thread) {
        target = thread;
    }

    @Override
    public void run() {
        Thread.State currentState = null;
        Thread.State prevState = null;
        while (true) {
            currentState = target.getState();
            if (currentState != prevState) {
                System.out.println(currentState);
                prevState = currentState;
            }
            if (prevState == State.TERMINATED) break;
        }
    }
}
