package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.List;

public class PlayerShip extends Ship {

    private Direction direction = Direction.UP;

    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        this.setStaticView(ShapeMatrix.PLAYER);
    }

    public void verifyHit(List<Bullet> bullets) {

        if (!bullets.isEmpty() && this.isAlive) {
            for (Bullet bullet : bullets) {
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
            setAnimatedView(false,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD,
                    ShapeMatrix.DEAD_PLAYER);
        }
    }

    public void setDirection(Direction newDirection) {
        if (newDirection != Direction.DOWN) {
            this.direction = newDirection;
        }
    }


    public void move() {
        if (!isAlive) return;
        if (direction == Direction.LEFT) this.x--;
        if (direction == Direction.RIGHT) this.x++;
        if (this.x < 0) this.x = 0;
        if (this.x + this.width > SpaceInvadersGame.WIDTH) this.x = SpaceInvadersGame.WIDTH - this.width;
    }

    public Direction getDirection() {
        return direction;
    }


    @Override
    public Bullet fire() {
        if (!this.isAlive) {
            return null;
        }
        return new Bullet(x + 2, y - ShapeMatrix.BULLET.length, Direction.UP);
    }


    public void win(){
        setStaticView(ShapeMatrix.WIN_PLAYER);
    }
}
