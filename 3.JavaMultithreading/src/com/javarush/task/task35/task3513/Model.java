package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private Tile[][] gameTiles;
    private static final int FIELD_WIDTH = 4;
    int maxTile = 0;
    int score = 0;

    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> list = getEmptyTiles();
        if (!list.isEmpty()) {
            int index = (int) (list.size() * Math.random());
            Tile emptyTile = list.get(index);
            emptyTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyList = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    emptyList.add(gameTiles[i][j]);
                }
            }
        }
        return emptyList;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        int insertPosition = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (!tiles[i].isEmpty()) {
                if (i != insertPosition) {
                    tiles[insertPosition] = tiles[i];
                    tiles[i] = new Tile();
                    isChanged = true;
                }
                insertPosition++;
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int j = 0; j < 3; j++) {
            if (tiles[j].value != 0 && tiles[j].value == tiles[j + 1].value) {
                tiles[j].value = tiles[j].value * 2;
                tiles[j + 1].value = 0;
                score += tiles[j].value;

                if (tiles[j].value > maxTile) {
                    maxTile = tiles[j].value;
                }
                isChanged = true;
            }
        }
        if (isChanged) {
            Tile temp;
            for (int j = 0; j < 3; j++) {
                if (tiles[j].value == 0 && tiles[j + 1].value != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                }
            }
        }
        return isChanged;
    }

    private void rotateClockwise() {
        Tile[][] newGameField = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - i - 1; j++) {
                Tile tmp = gameTiles[i][j];
                newGameField[i][j] = gameTiles[FIELD_WIDTH - j - 1][i];
                newGameField[FIELD_WIDTH - j - 1][i] = gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1];
                newGameField[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1] = gameTiles[j][FIELD_WIDTH - i - 1];
                newGameField[j][FIELD_WIDTH - i - 1] = tmp;
            }
        }
        gameTiles = newGameField;
    }


    public void left() {
        int countOfActions = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {

            if (compressTiles(gameTiles[i])) {
                countOfActions++;
            }
            if (mergeTiles(gameTiles[i])) {
                compressTiles(gameTiles[i]);
                countOfActions++;
            }
        }
        if (countOfActions > 0) addTile();
    }
    public void right() {
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
    }

    public void up() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
    }

    public void down() {
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

}
