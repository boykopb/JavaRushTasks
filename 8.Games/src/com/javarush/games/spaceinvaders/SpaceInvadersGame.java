package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    public static final int COMPLEXITY = 5;
    private List<Bullet> enemyBullets;
    private PlayerShip playerShip;

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        for (Star star : stars) {
            star.draw(this);
        }
    }


    private void drawScene() {
        drawField();
        playerShip.draw(this);
        enemyFleet.draw(this);
        for (Bullet bullet : enemyBullets) {
            bullet.draw(this);
        }
    }

    private void createGame() {
        createStars();
        enemyFleet = new EnemyFleet();
        enemyBullets = new  ArrayList<Bullet>();
        playerShip = new PlayerShip();
        drawScene();
        setTurnTimer(40);
    }


    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createStars() {
        stars = new ArrayList<Star>();
        for (int i = 0; i < 8; i++) {
            stars.add(new Star(i * Math.random() * 5, i * Math.random() * 4));
        }

    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet fireShot = enemyFleet.fire(this);
        if (fireShot != null) enemyBullets.add(fireShot);
        drawScene();
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        for (Bullet bullet : enemyBullets) {
            bullet.move();
        }
    }

    private void removeDeadBullets() {
        for (Bullet bullet : new ArrayList<>(enemyBullets)) {
            if (!bullet.isAlive || bullet.y >= HEIGHT - 1) {
                enemyBullets.remove(bullet);
            }
        }
    }
    private void check() {
        playerShip.verifyHit(enemyBullets);
        removeDeadBullets();
    }


}
