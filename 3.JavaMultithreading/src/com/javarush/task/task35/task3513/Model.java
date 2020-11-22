package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private Tile[][] gameTiles;
    private static final int FIELD_WIDTH = 4;
    int maxTile = 0;
    int score = 0;
    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean isSaveNeeded = true;


    public Model() {
        resetGameTiles();
        previousStates = new Stack();
        previousScores = new Stack();
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


    public Tile[][] getGameTiles() {
        return gameTiles;
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
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        for (int i = 0; i < FIELD_WIDTH; i++) {

            if (compressTiles(gameTiles[i])) {
                countOfActions++;
            }
            if (mergeTiles(gameTiles[i])) {
                compressTiles(gameTiles[i]);
                countOfActions++;
            }
        }
        if (countOfActions > 0) {
            addTile();
        }
        isSaveNeeded = true;

    }

    public void right() {
        saveState(gameTiles);
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
    }

    public void up() {
        saveState(gameTiles);
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        left();
        rotateClockwise();
    }

    public void down() {
        saveState(gameTiles);
        rotateClockwise();
        left();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    public boolean canMove() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                //если есть клетка со значением = 0, можем играть дальше
                if (gameTiles[i][j].value == 0) return true;

                //если значения в соседних клетках (горизонталь) равны, можем играть дальше
                if (i < FIELD_WIDTH - 1
                        && gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    return true;
                }

                //если значения в соседних клетках (вертикаль) равны, можем играть дальше
                if (j < FIELD_WIDTH - 1
                        && gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                    return true;
                }
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tempTiles);
        previousScores.push(score);
        isSaveNeeded = false;

    }


    public void rollback() {
        if (!previousScores.empty() && !previousStates.empty()) {
            score = previousScores.pop();
            gameTiles = previousStates.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    private boolean hasBoardChanged() {
        Tile[][] prevTile = previousStates.peek();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value != prevTile[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    private MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency result = new MoveEfficiency(-1, 0, move);

        move.move();
        if (this.hasBoardChanged()) {
            result = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        rollback();
        return result;
    }

    void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        queue.add(getMoveEfficiency(this::right));

        queue.peek().getMove().move();
    }
}
