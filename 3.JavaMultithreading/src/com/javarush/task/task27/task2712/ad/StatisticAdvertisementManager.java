package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {

    private static class InstanceHolder {
        private static final StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    }

    public static StatisticAdvertisementManager getInstance() {
        return StatisticAdvertisementManager.InstanceHolder.ourInstance;
    }

    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public List<Advertisement> getActiveList(){
        List<Advertisement> activeList = new ArrayList<>();
        for (Advertisement ad : advertisementStorage.list()) {
            if (ad.isActive()) activeList.add(ad);
        }
        return activeList;
    }

    public List<Advertisement> getArchiveList(){
        List<Advertisement> archiveList = new ArrayList<>();
        for (Advertisement ad : advertisementStorage.list()) {
            if (!ad.isActive()) archiveList.add(ad);
        }
        return archiveList;
    }

}
