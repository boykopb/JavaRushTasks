package com.javarush.games.racer.road;

import com.javarush.games.racer.RacerGame;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    
    private  RoadObject createRoadObject(RoadObjectType type, int x, int y) {
        Thorn thorn = null;

        if (type == RoadObjectType.THORN) {
            thorn = new Thorn(x, y);
        }
        return thorn;

    }

}
