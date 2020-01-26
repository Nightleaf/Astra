package com.nightleaf.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Tile {

	public Tile(int id) {
		this.id = id;
	}

	/**
	 * Initializes the tile.
	 */
	public abstract void init();

	/**
	 * This will render the tile.
	 * 
	 * @param g
	 */
	public abstract void render(Graphics g);

	/**
	 * This will update the tile.
	 */
	public abstract void update();

	/**
	 * Sets the tiles color overlay.
	 * 
	 * @param col
	 */
	public void setColor(Color col) {
		this.tileColor = col;
	}

	public Color tileColor;
	public Image tileSprite;
	public int id;
	public int posX;
	public int posY;
}
