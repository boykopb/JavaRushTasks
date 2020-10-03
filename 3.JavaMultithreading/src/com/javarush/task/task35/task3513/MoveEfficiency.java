package com.javarush.task.task35.task3513;

class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    @Override
    public int compareTo(MoveEfficiency other) {
        int result = Integer.compare(this.numberOfEmptyTiles, other.numberOfEmptyTiles);

        if (result == 0) {
            result = Integer.compare(this.score, other.score);
        }
        return result;
    }
    public Move getMove() {
        return move;
    }
}