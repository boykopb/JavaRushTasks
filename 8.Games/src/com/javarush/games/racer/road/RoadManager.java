package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private List<RoadObject> items = new ArrayList<>();


    private RoadObject createRoadObject(RoadObjectType type, int x, int y) {
        RoadObject result = null;

        if (type == RoadObjectType.THORN) {
            result = new Thorn(x, y);
        }
        if (type != RoadObjectType.THORN) {
            result = new Car(type, x, y);
        }
        return result;

    }


    private void addRoadObject(RoadObjectType type, Game game) {
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject newRoadObject = createRoadObject(type, x, y);
        if (newRoadObject != null) {
            items.add(newRoadObject);
        }
    }

    public void draw(Game game) {
        for (RoadObject item : items) {
            item.draw(game);
        }
    }

    public void move(int boost) {
        for (RoadObject item : items) {
            item.move(boost + item.speed);
        }
        deletePassedItems();
    }


    private boolean isThornExists() {
        Boolean isThorn = false;
        for (RoadObject item : items) {
            if (item.type == RoadObjectType.THORN) {
                isThorn = true;
                break;
            }
        }
        return isThorn;
    }

    private void generateThorn(Game game) {
        int randomNumber = game.getRandomNumber(100);
        if (randomNumber < 10 && !isThornExists()) {
            addRoadObject(RoadObjectType.THORN, game);
        }
    }

    public void generateNewRoadObjects(Game game) {
        generateThorn(game);
        generateRegularCar(game);
    }

    private void deletePassedItems() {
        for (RoadObject item : new ArrayList<>(items)) {
            if (item.y >= RacerGame.HEIGHT) {
                items.remove(item);
            }
        }
    }


    public boolean checkCrush(PlayerCar playerCar) {
        for (RoadObject item : items) {
            if (item.isCollision(playerCar)) {
                return true;
            }
        }
        return false;
    }

    private void generateRegularCar(Game game) {
        if (game.getRandomNumber(100) < 30) {
            int carTypeNumber = game.getRandomNumber(4);
            addRoadObject(RoadObjectType.values()[carTypeNumber], game);
        }
    }
}
