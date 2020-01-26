package com.nightleaf.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public abstract class Entity {

	public abstract void init(GameContainer container) throws SlickException;

	public abstract void render(Graphics g) throws SlickException;

	public abstract void update(GameContainer container);

	public int posX;
	public int posY;
}
