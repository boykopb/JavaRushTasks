package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 19;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private int countClosedTiles = SIDE * SIDE;
    private boolean isGameStopped;
    private boolean isWin;

    private int countOfTry;

    private int score;


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.GRAY);
                setCellValue(x, y, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
        countOfTry = 3;


    }

    private void gameOver() {
        isGameStopped = true;
        if (countOfTry == 0) {
            showMessageDialog(Color.CRIMSON,
                    "Maybe next time..." +
                            "\n   Score = " + score,
                    Color.BLACK, 25);
            return;
        }
        showMessageDialog(Color.CRIMSON,
                "  Ooops...." +
                        "\nTries left: " + countOfTry,
                Color.BLACK, 25);

    }

    private void tryAgain() {
        isGameStopped = false;
    }


    private void win() {
        isGameStopped = true;
        isWin = true;
        showMessageDialog(Color.LAVENDER,"  YOU WIN!" +
                "\n Score = "+ score, Color.BLACK, 25);
    }


    private void restart() {

        isGameStopped = false;
        isWin = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        countFlags = 0;
        setScore(score);
        createGame();

    }


    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }


    private void countMineNeighbors() {
        List<GameObject> list;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (!gameField[y][x].isMine) {
                    list = getNeighbors(gameField[y][x]);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isMine) {
                            gameField[y][x].countMineNeighbors++;
                        }
                    }
                }
            }
        }

    }

    private void openTile(int x, int y) {
        GameObject field = gameField[y][x];

        if (field.isOpen || field.isFlag || isGameStopped) {
            return;
        }

        field.isOpen = true;
        countClosedTiles--;


        if (!field.isMine) {
            score += 5;
            setScore(score);
        }

        if (field.isMine) {
            countOfTry--;
            setCellValueEx(x, y, Color.RED, MINE);

            //если отрываем последний tile, а там мина, но еще есть попытки => победа
            if (countClosedTiles == countMinesOnField && countOfTry > -1) {
                win();
                return;
            }
            //иначе = проиграли
            gameOver();
            return;
        }

        if (countClosedTiles == countMinesOnField) {
            win();
        }


        if (field.countMineNeighbors == 0) {
            getNeighbors(field).forEach(neighbour -> openTile(neighbour.x, neighbour.y));
            setCellValueEx(x, y, Color.GREENYELLOW, "");
            return;
        }

        setCellNumber(x, y, field.countMineNeighbors);
        setCellColor(x, y, Color.GREENYELLOW);

    }


    private void markTile(int x, int y) {
        GameObject currentField = gameField[y][x];
        if (!currentField.isOpen && !isGameStopped) {
            if (currentField.isFlag) {
                currentField.isFlag = false;
                countFlags++;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.GRAY);
            } else if (countFlags > 0) {
                currentField.isFlag = true;
                countFlags--;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.YELLOW);
            }

        }

    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped && countOfTry > 0 && !isWin) {
            tryAgain();
            return;
        }

        if (isGameStopped && countOfTry == 0 || isWin) {
            restart();
            return;
        }


        openTile(x, y);


    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}