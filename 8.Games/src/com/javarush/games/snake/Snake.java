package com.javarush.games.snake;

import java.util.ArrayList;
import java.util.List;

import com.javarush.engine.cell.*;

public class Snake extends GameObject {

    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public Snake(int x, int y) {
        super(x, y);
        for (int i = 0; i < 3; i++) snakeParts.add(new GameObject(x + i, y));
    }

    public void setDirection(Direction direction) {
        if (this.direction == Direction.DOWN && !(direction == Direction.UP)) this.direction = direction;
        if (this.direction == Direction.UP && !(direction == Direction.DOWN)) this.direction = direction;
        if (this.direction == Direction.RIGHT && !(direction == Direction.LEFT)) this.direction = direction;
        if (this.direction == Direction.LEFT && !(direction == Direction.RIGHT)) this.direction = direction;

    }

    public void draw(Game game) {
        Color color = isAlive ? Color.BLACK : Color.RED;
        for (int i = 0; i < snakeParts.size(); i++) {
            if (i == 0) {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, HEAD_SIGN, color, 75);
            } else {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, color, 75);
            }
        }
    }

    public GameObject createNewHead() {
        GameObject snakeHead = snakeParts.get(0);
        GameObject object = null;

        if (this.direction == Direction.LEFT) object = new GameObject(snakeHead.x - 1, snakeHead.y);
        if (this.direction == Direction.RIGHT) object = new GameObject(snakeHead.x + 1, snakeHead.y);
        if (this.direction == Direction.DOWN) object = new GameObject(snakeHead.x, snakeHead.y + 1);
        if (this.direction == Direction.UP) object = new GameObject(snakeHead.x, snakeHead.y - 1);


        return object;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.get(snakeParts.size() - 1));
    }

    public void move(Apple apple) {
        GameObject head = createNewHead();

        //съела яблоко = подросла
        if (head.x == apple.x && head.y == apple.y) {
            apple.isAlive = false;
            snakeParts.add(0, head);
            return;
        }

        //стукнулась об стены = смерть;
        if (head.x < 0 || head.x > SnakeGame.WIDTH - 1
                || head.y < 0 || head.y > SnakeGame.HEIGHT - 1) {
            this.isAlive = false;
            return;
        }

        //стукнулась об себя = смерть;
        if (checkCollision(createNewHead())) {
            this.isAlive = false;
            return;
        }

        snakeParts.add(0, head);
        removeTail();


    }


    public boolean checkCollision(GameObject gameObject) {
        boolean isCollision = false;
        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject snakePart = snakeParts.get(i);
            if (snakePart.x == gameObject.x && snakePart.y == gameObject.y) {
                isCollision = true;
                break;
            }
        }

        return isCollision;

    }

}
