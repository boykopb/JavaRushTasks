package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;


    private void drawField() {

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }

        for (int i = 0; i < stars.size(); i++) {
            stars.get(i).draw(this);

        }

    }
    private void drawScene() {
        drawField();
    }
    private void createGame() {
        createStars();
        drawScene();
    }

          
    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createStars(){
        stars = new ArrayList<Star>();
        for (int i = 0; i < 8; i++) {
            stars.add(new Star(i*Math.random()*5, i*Math.random()*4));
        }

    }






}
