package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg zerg1 = new Zerg();
        zerg1.name = "ZERG1";
        Zerg zerg2 = new Zerg();
        zerg2.name = "ZERG2";
        Zerg zerg3 = new Zerg();
        zerg3.name = "ZERG3";
        Zerg zerg4 = new Zerg();
        zerg4.name = "ZERG4";
        Zerg zerg5 = new Zerg();
        zerg5.name = "ZERG5";


        Protoss prot1 = new Protoss();
        prot1.name = "Prot1";
        Protoss prot2 = new Protoss();
        prot2.name = "Prot2";
        Protoss prot3 = new Protoss();
        prot3.name = "Prot3";

        Terran terr1 = new Terran();
        terr1.name = "Terr1";
        Terran terr2 = new Terran();
        terr2.name = "Terr2";
        Terran terr3 = new Terran();
        terr3.name = "Terr3";
        Terran terr4 = new Terran();
        terr4.name = "Terr4";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
