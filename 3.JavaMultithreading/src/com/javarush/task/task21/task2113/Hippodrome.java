package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    void run () throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    void move(){
        for (Horse h : horses) h.move();
    }

    void print(){
        for (Horse h : horses) h.print();

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner () {
        double maxDistance = 0;
        Horse winner = null;

        for (Horse h : horses) {
            if (h.getDistance() > maxDistance) {
                maxDistance = h.getDistance();
                winner = h;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.printf("Winner is %s!", getWinner().getName());
        System.out.println();
    }




    public static void main(String[] args) throws InterruptedException {
        List<Horse> horseList = new ArrayList<>();

        Horse horse1 = new Horse("Сивка", 3, 0);
        Horse horse2 = new Horse("Бурка", 3, 0);
        Horse horse3 = new Horse("Вихрь", 3, 0);
        horseList.add (horse1);
        horseList.add (horse2);
        horseList.add (horse3);
        game = new Hippodrome(horseList);

        game.run();
        game.printWinner();
    }
}
