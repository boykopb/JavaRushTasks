package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.List;

public class PlayerShip extends Ship {
    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        this.setStaticView(ShapeMatrix.PLAYER);
    }

    public void verifyHit(List<Bullet> bullets) {

       if (!bullets.isEmpty() && this.isAlive) {
           for (Bullet bullet : bullets){
               if (bullet.isAlive && this.isCollision(bullet)) {
                   this.kill();
                   bullet.kill();
               }
           }
       }
    }

    @Override
    public void kill() {
        if (this.isAlive) {
            this.isAlive = false;
            setAnimatedView(ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD,
                    ShapeMatrix.DEAD_PLAYER);
        }
    }
}
