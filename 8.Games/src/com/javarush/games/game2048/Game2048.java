package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import java.util.Arrays;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score = 0;


    private void createGame() {
        //создаем матрицу заново;
        gameField = new int[SIDE][SIDE];
        //создаем 2 числа;
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
        if (getMaxTileValue() == 2048) {
            win();
        }

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
                return Color.FUCHSIA;
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
        for (int i = 0; i < row.length; i++) {
            for (int j = i + 1; j < row.length; j++) {
                if (row[i] == 0 && row[j] != 0) {
                    row[i] = row[j];
                    row[j] = 0;
                    hasMoved = true;
                }
            }
        }
        return hasMoved;
    }


    private boolean mergeRow(int[] row) {
        boolean hasMerged = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] = row[i] * 2;
                score += row[i];
                setScore(score);
                row[i + 1] = 0;
                hasMerged = true;
            }
        }
        return hasMerged;
    }

    @Override
    public void onKeyPress(Key key) {
        //проверяем есть ли возможность хода
        if (!canUserMove()) {
            gameOver();
            //рестарт игры, если проиграли (по кнопке SPACE)
            if (key == Key.SPACE) {
                showMessageDialog(Color.GOLD, "", Color.BLACK, 25);
                isGameStopped = false;
                createGame();
                drawScene();
                score = 0;
                setScore(score);
            }
            return;
        }
        //кнопки работают только если еще не проиграли
        if (!isGameStopped) {
            System.out.println("key= " + key);
            switch (key) {
                case LEFT:
                    moveLeft();
                    drawScene();
                    break;
                case RIGHT:
                    moveRight();
                    drawScene();
                    break;
                case UP:
                    moveUp();
                    drawScene();
                    break;
                case DOWN:
                    moveDown();
                    drawScene();
                    break;
            }
        }


    }


    private void rotateClockwise() {
        int[][] newGameField = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE / 2; i++) {
            for (int j = i; j < SIDE - i - 1; j++) {
                int tmp = gameField[i][j];
                newGameField[i][j] = gameField[SIDE - j - 1][i];
                newGameField[SIDE - j - 1][i] = gameField[SIDE - i - 1][SIDE - j - 1];
                newGameField[SIDE - i - 1][SIDE - j - 1] = gameField[j][SIDE - i - 1];
                newGameField[j][SIDE - i - 1] = tmp;
            }
        }
        gameField = newGameField;
    }


    private void moveLeft() {
        int countOfActions = 0;
        for (int i = 0; i < SIDE; i++) {

            if (compressRow(gameField[i])) {
                countOfActions++;
            }
            if (mergeRow(gameField[i])) {
                compressRow(gameField[i]);
                countOfActions++;
            }
        }
        if (countOfActions > 0) createNewNumber();

    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private int getMaxTileValue() {
        int maxValue = 0;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[j][i] > maxValue) maxValue = gameField[j][i];
            }
        }
        return maxValue;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.GOLD, "YOU WIN!", Color.BLACK, 25);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.GOLD, "GAME OVER!", Color.BLACK, 25);
    }

    private boolean canUserMove() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                //если есть клетка со значением = 0, можем играть дальше
                if (gameField[i][j] == 0) return true;

                //если значения в соседних клетках (горизонталь) равны, можем играть дальше
                if (i < SIDE - 1 && gameField[i][j] == gameField[i + 1][j]) return true;

                //если значения в соседних клетках (вертикаль) равны, можем играть дальше
                if (j < SIDE - 1 && gameField[i][j] == gameField[i][j + 1]) return true;
            }
        }
        return false;
    }
}
