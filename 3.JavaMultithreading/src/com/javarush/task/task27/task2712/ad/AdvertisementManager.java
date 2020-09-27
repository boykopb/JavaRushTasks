package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }

        List<Advertisement> videos = new ArrayList<>(storage.list());

        Comparator<Advertisement> byDuration = (o1, o2) -> (o1.getDuration() - o2.getDuration());
        Comparator<Advertisement> byAmountOneDisplaying = (o1, o2) -> (int) (o1.getAmountPerOneDisplaying() - o2.getAmountPerOneDisplaying());

        videos.sort(byDuration);
        videos.sort(byAmountOneDisplaying);
        Collections.reverse(videos);

        int cookingTime = timeSeconds;
        for (Advertisement video : videos) {
            if (video.getDuration() <= cookingTime && video.getAmountPerOneDisplaying() > 0) {
                System.out.println(video.getName()
                        + " is displaying... "
                        + video.getAmountPerOneDisplaying()
                        + ", "
                        + video.getAmountPerOneDisplaying() * 1000 / video.getDuration());
                video.revalidate();
                cookingTime -= video.getDuration();
            }
        }

    }
}
