package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[y].length; x++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }

        }
    }

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createNewNumber() {
        int randomX;
        int randomY;

        do {
            randomX = getRandomNumber(SIDE);
            randomY = getRandomNumber(SIDE);
        } while (gameField[randomY][randomX] != 0);

        if (getRandomNumber(10) == 9) {
            gameField[randomY][randomX] = 4;

        } else {
            gameField[randomY][randomX] = 2;
        }
    }


    private Color getColorByValue(int value) {

        switch (value) {
            case 2:
                return Color.FIREBRICK;
            case 4:
                return Color.GOLD;
            case 8:
                return Color.BISQUE;
            case 16:
                return Color.CADETBLUE;
            case 32:
                return Color.GAINSBORO;
            case 64:
                return Color.LIGHTGREEN;
            case 128:
                return Color.LIGHTCORAL;
            case 256:
                return Color.LIGHTGOLDENRODYELLOW;
            case 512:
                return Color.LIGHTSKYBLUE;
            case 1024:
                return Color.GREEN;
            case 2048:
                return Color.RED;
            default:
                return Color.WHEAT;
        }
    }

    private void setCellColoredNumber(int x, int y, int value) {
        String valueOfCell = "";
        if (value != 0) valueOfCell = String.valueOf(value);

        setCellValueEx(x, y, getColorByValue(value), valueOfCell);
    }

    private boolean compressRow(int[] row) {
        boolean hasMoved = false;
        for (int i = 0; i < row.length; i++){
            for (int j = i + 1; j < row.length; j++){
                if (row[i] == 0 && row[j] != 0){
                    row[i] = row[j];
                    row[j] = 0;
                    hasMoved = true;
                }
            }
        }
        return hasMoved;
    }

}
