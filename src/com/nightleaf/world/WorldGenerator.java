package com.nightleaf.world;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.newdawn.slick.Color;

import com.nightleaf.Config;
import com.nightleaf.world.tiles.GrassTile;
import com.nightleaf.world.tiles.SandTile;
import com.nightleaf.world.tiles.WaterTile;

public class WorldGenerator {

	/**
	 * Will generate a new world for us.
	 * 
	 */
	public static void generateWorld() {
		int size = 100;
		if (doesWorldExist()) {
			loadWorld();
			return;
		} else {
			World.tileMap = new Tile[size][size];
			for (int x = 0; x < size; x++) {
				for (int y = 0; y < size; y++) {
					World.tileMap[x][y] = new GrassTile();
					World.tileMap[x][y].posX = x;
					World.tileMap[x][y].posY = y;
					World.tileMap[x][y].init();
				}
			}
			saveWorld();
		}
	}

	/**
	 * Saves the world data to a file.
	 */
	public static void saveWorld() {
		DataOutputStream output = null;
		try {
			output = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(Config.RESOURCE_PATH
							+ "world/world.dat")));
			int size = 100;
			for (int x = 0; x < size; x++) {
				for (int y = 0; y < size; y++) {
					output.writeInt(World.tileMap[x][y].id);
					output.writeFloat(World.tileMap[x][y].tileColor.r);
					output.writeFloat(World.tileMap[x][y].tileColor.g);
					output.writeFloat(World.tileMap[x][y].tileColor.b);
					output.writeInt(x);
					output.writeInt(y);
				}
			}
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the world file into memory.
	 * 
	 */
	public static void loadWorld() {
		int size = 100;
		System.out.println("Map size: " + size);
		World.tileMap = new Tile[size][size];
		DataInputStream input = null;
		try {
			input = new DataInputStream(new BufferedInputStream(
					new FileInputStream(Config.RESOURCE_PATH
							+ "world/world.dat")));
			for (int i = 0; i < 100; i++) {
				for (int i2 = 0; i2 < 100; i2++) {
					int id = input.readInt();
					float r = input.readFloat();
					float g = input.readFloat();
					float b = input.readFloat();
					int posX = input.readInt();
					int posY = input.readInt();
					World.tileMap[i][i2] = getTileForId(id);
					World.tileMap[i][i2].posX = posX;
					World.tileMap[i][i2].posY = posY;
					World.tileMap[i][i2].setColor(new Color(r, g, b));
				}
			}
			input.close();
			initTiles();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes all tiles in the world.
	 */
	private static void initTiles() {
		int size = 100;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (World.tileMap[x][y] != null)
					World.tileMap[x][y].init();
			}
		}
	}

	/**
	 * Checks if a world file already exists
	 * 
	 * @return
	 */
	private static boolean doesWorldExist() {
		File worldFile = null;
		try {
			worldFile = new File(Config.RESOURCE_PATH + "world/world.dat");
			if (!worldFile.exists()) {
				worldFile.createNewFile();
				return false;
			}
			if (worldFile.exists()) {
				if (worldFile.length() > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Gets the tile by its id.
	 * 
	 * @param id
	 * @return
	 */
	public static Tile getTileForId(int id) {
		switch (id) {
		case 0:
			return new GrassTile();
		case 1:
			return new SandTile();
		case 2:
			return new WaterTile();
		}
		return null;
	}
}
