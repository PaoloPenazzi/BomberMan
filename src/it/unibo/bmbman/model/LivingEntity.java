package it.unibo.bmbman.model;

import java.awt.geom.Point2D;

import it.unibo.bmbman.model.utilities.Velocity;

/**
 * Interface to model a living entity that is an entity with one or more lives and capable of moving.
 *
 */
public interface LivingEntity {
    /**
     * 
     * @return true if the entity still has one or more lives, false otherwise
     */
    boolean isAlive();
    /**
     * Add a life.
     */
    void addLife();
    /**
     * Remove a life.
     */
    void removeLife();
    /**
     * 
     * @return the number of lives of the entity
     */
    int getLives();
    /**
     * Used to set entity's position.
     * @param position where the entity have to be moved
     */
    void move(Point2D position);
//    /**
//     * Used to increase entity's speed.
//     * @param s how much velocity have to be increment
//     */
//    /*per la velocità è sicuramente meglio scomporre le due coordinate
//    ma come gestire l'incremento e il decremento?*/
//    void incrementSpeed(int s);
//    /**
//     * Used to decrease entity's speed.
//     * @param s how much velocity have to be decrement
//     */
//    void decrementSpeed(int s);
    /**
     * Used to know the velocity of the entity.
     * @return the velocity
     */
    Velocity getVelocity();
    /**
     * Used to set entity's velocity.
     * @param velocity the value of velocity
     */
    void setVelocity(Velocity velocity);
    /**
     * set direction in which the entity must move.
     * @param direction 
     */
    void setDirection(Direction direction);
    /**
     * 
     * @return the direction in which the entity is moving
     */
    Direction getDirection();
}