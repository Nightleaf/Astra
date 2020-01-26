package com.nightleaf.world;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class Object {
	
	public Object(int id, int size) {
		this.id = (byte) id;
		this.size = (byte) size;
	}
	
	/**
	 * Initializes the object.
	 */
	public abstract void init();

	/**
	 * This will render the object.
	 * 
	 * @param g
	 */
	public abstract void render(Graphics g);

	/**
	 * This will update the object.
	 */
	public abstract void update();
	
	/**
	 * Sets the tiles color overlay.
	 * @param col
	 */
	public void setColor(Color col) {
		this.objectColor = col;
	}
	
	public Color objectColor;
	public Image objectSprite;
	public final byte size;
	public final byte id;
	public int posX;
	public int posY;
}
