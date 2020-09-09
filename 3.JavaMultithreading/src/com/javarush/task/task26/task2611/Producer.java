package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private ConcurrentHashMap<String, String> map;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            while (true) {
                atomicInteger.incrementAndGet();
                String s = "Some text for " + atomicInteger;
                map.put(String.valueOf(atomicInteger), s);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
        }

    }
}
