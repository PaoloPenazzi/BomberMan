package it.unibo.bmbman.view.entities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.EnumMap;
import java.util.Map;

import it.unibo.bmbman.model.Direction;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.view.utilities.Animation;
import it.unibo.bmbman.view.utilities.AnimationImpl;
import it.unibo.bmbman.view.utilities.SpriteSheet;
/**
 * Class to manage the view of monsters.
 *
 *
 */
public class MonsterView extends AbstractEntityView {
    private static final String PATH_MONSTER_IMAGES = "/Monster/monster";
    private static final int DIMENSION = 43;
    private static final int FRAME_PER_ANIMATION = 3;
    private final Map<Direction, Animation> sprites = new EnumMap<>(Direction.class);

    /**
     * Create a monster view.
     * @param position where the monster is located
     * @param dimension the dimension of the monster
     */
    public MonsterView(final Point position, final Dimension dimension) {
        super(position, new Dimension(DIMENSION, DIMENSION), true); 
        setMapDirection();
    }
    private void setMapDirection() {
//        SpriteSheet ss = new SpriteSheet(PATH_MONSTER_IMAGES + "I.png");
//        this.sprites.put(Direction.IDLE, new AnimationImpl());
//        this.sprites.get(Direction.IDLE).addFrame(ss.getSprite(1, 1, DIMENSION));
        for (int i = 0; i < Direction.values().length - 1; i++) {
            System.out.println("setto " + i + " " + Direction.values()[i]);
            setDirectionAnimation(PATH_MONSTER_IMAGES + Direction.values()[i].toString().charAt(0) + ".png", 
                    Direction.values()[i], DIMENSION, FRAME_PER_ANIMATION);
        }
    }

    private void setDirectionAnimation(final String path, final Direction d, final int dimension, final int frame) {
        this.sprites.put(d, new AnimationImpl());
        this.sprites.get(d).createAnimation(path, frame, dimension);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Image getSprite() {
        return this.sprites.get(this.getDirection()).getNextImage();
    }
}
