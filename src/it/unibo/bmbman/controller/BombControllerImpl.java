package it.unibo.bmbman.controller;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.sun.corba.se.spi.orbutil.fsm.State;

import it.unibo.bmbman.model.Bomb;
import it.unibo.bmbman.model.CollisionImpl;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.utilities.Pair;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.BombState;
import it.unibo.bmbman.view.entities.BombView;
/**
 *
 */
public class BombControllerImpl implements BombController {
    private List<Pair<Bomb, BombView>> amountBombs;
    private SoundsController sc;
    /**
     */
    public BombControllerImpl(final SoundsController soundsController) {
        super();
        this.amountBombs = new ArrayList<>();
        this.sc = soundsController;
    }
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public List<Pair<Bomb, BombView>> getBombsToRemove() {
        return this.amountBombs.stream().filter(b -> b.getX().remove())
                .collect(Collectors.toList());
    }
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public List<Bomb> getBombsInExplosion() {
        return this.amountBombs.stream()
                .filter(b -> b.getX().getState() == BombState.IN_EXPLOSION)
                .map(b -> b.getX())
                .collect(Collectors.toList());
    }
    /**
     * 
     * {@inheritDoc} 
     * 
     */
    @Override
    public Optional<Bomb> plantBomb(final Hero hero) {
        if (hero.getBombNumber() - this.amountBombs.size() >= 1) {
            final Position pos = new Position(Position.getCenteredPosition(hero.getPosition()));
            final Bomb b = new Bomb(pos);
            b.startTimer();
            this.amountBombs.add(new Pair<Bomb, BombView>(b, new BombView(pos)));
            if (sc.getEffectState()) {
                sc.getPlaceBombSound().play();
            }
            return Optional.of(b);
        }
        return Optional.empty();
    }
    /**
     * 
     * {@inheritDoc} 
     */
    @Override
    public void update(final Graphics g) {
        this.amountBombs.forEach(b -> b.getX().update());
        this.amountBombs.forEach(b -> {
            b.getY().setBombState(b.getX().getState());
            b.getY().render(g); 
            if (b.getX().getState() == BombState.IN_EXPLOSION) {
                if (sc.getEffectState()) {
                    sc.getExplosionSound().play();
                }
            }
        });
    }
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void removeBomb() {
        this.amountBombs.removeAll(getBombsToRemove());
    }
    /**
     * 
     * {@inheritDoc} 
     */
    @Override
    public void collision(final Set<Entity> entities) {
        this.getBombsInExplosion().forEach(b -> {
            entities.forEach(e -> {
                if (checkCollision(e, b.getExplosion().getX()) || checkCollision(e, b.getExplosion().getY())) {
                    this.notifyCollision(e, b, e.getPosition());
                }
            });
        });
        this.getBombsInExplosion().forEach(b -> b.setBombExploded());
    }
    private boolean checkCollision(final Entity receiver, final Rectangle collider) {
        return receiver.getCollisionComponent().getHitbox().intersects(collider);
    }
    private void notifyCollision(final Entity receiver, final Bomb b, final Position position) {
        receiver.onCollision(new CollisionImpl(b, receiver.getPosition()));
    }
}