package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Long> profitMap = statisticManager.getProfitMap();
        ArrayList<String> list = new ArrayList(profitMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            double amount = 1.0 * profitMap.get(key) / 100;
            System.out.println(key + " - " + String.format(Locale.ENGLISH, "%.2f", amount));
        }
    }

    public void printCookWorkloading() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Map<String, Integer>> cookWorkloadingMap = statisticManager.getCookWorkloadingMap();
        ArrayList<String> list = new ArrayList(cookWorkloadingMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            Map<String, Integer> cookMap = cookWorkloadingMap.get(key);
            System.out.println(key);

            ArrayList<String> cookNames = new ArrayList(cookMap.keySet());
            Collections.sort(cookNames);
            for (String cookName : cookNames) {
                System.out.println(cookName + " - " + ((cookMap.get(cookName) + 59) / 60) + " min");
            }

            System.out.println();
        }
    }
/*
4. Реализуй логику методов printActiveVideoSet и printArchivedVideoSet в классе DirectorTablet.
Используй методы/метод, созданные в предыдущем пункте.
Сортировать по имени видео-ролика в алфавитном порядке
Сначала английские, потом русские.

Пример вывода для printActiveVideoSet:
First Video - 100
Second video - 10
Third Video - 2
четвертое видео - 4

Через 50 показов пример вывода для printArchivedVideoSet:
Second video
Third Video
четвертое видео


 */
    public void printActiveVideoSet() {
        List<Advertisement> result = StatisticAdvertisementManager.getInstance().getActiveList();
        Collections.sort(result, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement advertisement : result) {
            System.out.println(advertisement.getName() + " - " + advertisement.getHits());
        }

    }

    public void printArchivedVideoSet() {
        List<Advertisement> result = StatisticAdvertisementManager.getInstance().getArchiveList();
        Collections.sort(result, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Advertisement advertisement : result) {
            System.out.println(advertisement.getName() + " - " + advertisement.getHits());
        }
    }
}
