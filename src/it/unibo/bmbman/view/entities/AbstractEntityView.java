package it.unibo.bmbman.view.entities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
/**
 * Abstarct implementation of entityView.
 */
public abstract class AbstractEntityView implements EntityView {

    private Point position;
    private  Dimension dimension;
    private Image image;
    private boolean visible;
    /**
     * Constructor for an EntityView.
     * @param position where is the entity in our terrien
     * @param dimension the dimension of entity
     * @param image the image of entity
     * @param visible if the enity is visible or not
     */
    public AbstractEntityView(final Point position, final Dimension dimension, final Image image, final boolean visible) {
        this.position = position;
        this.dimension = dimension;
        this.image = image;
        this.visible = visible;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(final Point position) {
        this.position = position;

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Point getPosition() {
        return this.position;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setDimension(final Dimension dimension) {
        this.dimension = dimension;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getDimension() {
        return this.dimension;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void render(Graphics g);
    /**
     * {@inheritDoc}
     */
    @Override
    public void setSprite(final Image image) {
        this.image = image;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Image getSprite() {
        return this.image;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setVisible(final boolean visible) {
        this.visible = visible;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getVisible() {
        return this.visible;
    }


}