package com.nightleaf.world;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.nightleaf.Config;

public class World {

	/**
	 * Loads all the resources for world generation.
	 * 
	 * @param container
	 * @throws SlickException
	 */
	public static void init(GameContainer container) throws SlickException {
		rand = new Random();
		WorldGenerator.generateWorld();
		tileSprites = new Image[3];
		tileSprites[0] = new Image(Config.RESOURCE_PATH
				+ "sprites/tiles/grass0.png");
		tileSprites[1] = new Image(Config.RESOURCE_PATH
				+ "sprites/tiles/sand0.png");
		tileSprites[2] = new Image(Config.RESOURCE_PATH
				+ "sprites/tiles/water0.png");
		offsetX = 0;
		offsetY = 0;
	}

	/**
	 * Renders the world so that the player can see it.
	 * 
	 * @param g
	 * @throws SlickException
	 */
	public static void renderWorld(Graphics g) throws SlickException {
		g.setBackground(Color.gray);
		g.scale(4.0f, 4.0f);
		for (int i = 0; i < tileSprites.length; i++) {
			tileSprites[i].setFilter(Image.FILTER_NEAREST);
		}
		for (int xx = 0; xx < Config.MAP_WIDTH; xx++) {
			for (int yy = 0; yy < Config.MAP_HEIGHT; yy++) {
				if (tileMap[yy][xx] != null) {
					tileMap[yy][xx].render(g);
				}
			}
		}
	}

	/**
	 * Updates all tiles within the world.
	 */
	public static void updateWorld() {
		for (int xx = 0; xx < Config.MAP_WIDTH; xx++) {
			for (int yy = 0; yy < Config.MAP_HEIGHT; yy++) {
				if (tileMap[yy][xx] != null) {
					tileMap[yy][xx].update();
				}
			}
		}
		if (System.currentTimeMillis() - garbageCleanup > 10000) {
			System.gc();
			garbageCleanup = System.currentTimeMillis();
		}
	}

	public static int offsetX;
	public static int offsetY;
	private static Random rand;
	public static Image[] tileSprites;
	public static Object[][] objectMap;
	public static Tile[][] tileMap;
	private static long garbageCleanup = System.currentTimeMillis();
}
