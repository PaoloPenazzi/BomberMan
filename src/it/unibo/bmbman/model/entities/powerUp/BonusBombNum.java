package it.unibo.bmbman.model.entities.powerUp;

import it.unibo.bmbman.model.entities.Bomb;
import it.unibo.bmbman.model.entities.HeroImpl;
import it.unibo.bmbman.model.utilities.Position;
/**
 * Model a bonus bomb number power-up.
 */
public class BonusBombNum extends AbstractPowerupEntity {
    /**
     * Construct a bonus bomb number power-up in the world.
     * @param position where to create it.
     */
    public BonusBombNum(final Position position) {
        super(position, true);
    }
    /**
     * {@inheritDoc}}
     */
    @Override
    public void powerupEffect(final HeroImpl hero) {
        Bomb.incrementBombsNumber();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEffect(final HeroImpl hero) {
    }
}
