package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;

    private boolean isGameStopped;

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
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
        isGameStopped = false;

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
        field.isOpen = true;
        setCellColor(x, y, Color.GREEN);

        if (field.isMine) {
            //setCellValue(x, y, MINE);
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        }

        if (!field.isMine) {
            setCellNumber(x, y, field.countMineNeighbors);

            if (field.countMineNeighbors == 0) {
                setCellValue(x, y, "");
                List<GameObject> neighbours = getNeighbors(field);
                for (int i = 0; i < neighbours.size(); i++) {
                    if (!neighbours.get(i).isOpen && !neighbours.get(i).isMine) {
                        openTile(neighbours.get(i).x, neighbours.get(i).y);
                    }
                }
            }
        }

        if (!field.isMine && field.countMineNeighbors != 0) {
            setCellNumber(x, y, field.countMineNeighbors);
        }
    }


    /*
    2. Метод markTile(int x, int y) не должен ничего делать, если элемент уже открыт (isOpen == true).
    3. Метод markTile(int, int) не должен ничего делать, если количество неиспользованных флагов countFlags равно нулю,
     и текущий элемент — не флаг (isFlag = false).
    4. Метод markTile(int, int) должен устанавливать значение поля isFlag в true, уменьшать количество неиспользованных
     флагов на единицу, отрисовывать на поле знак FLAG, если текущий элемент — не флаг
      (используй метод setCellValue(int, int, String)) и менять фон ячейки на поле, используя метод setCellColor(int, int, Color).
      Например, в Color.YELLOW.
    5. Метод markTile(int, int) должен устанавливать значение поля isFlag в false, увеличивать количество неиспользованных
    флагов на единицу, отрисовывать на поле пустую ячейку, если текущий элемент — флаг
    (используй метод setCellValue(int, int, String)) и возвращать исходный цвет ячейки
    (используй метод setCellColor(int, int, Color)).
     */
    private void markTile(int x, int y) {
        GameObject currentField = gameField[y][x];
        if (!currentField.isOpen && !isGameStopped) {
            if (currentField.isFlag){
                currentField.isFlag = false;
                countFlags++;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
            }

            else if (countFlags > 0) {
                currentField.isFlag = true;
                countFlags--;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.YELLOW);
            }

        }

    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.BLUEVIOLET, "GAME OVER!", Color.BLACK, 50);

    }

}