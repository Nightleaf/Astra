package com.nightleaf;

import org.newdawn.slick.Color;

public class Config {

	/**
	 * The current build version.
	 */
	public final static String GAME_VERSION = "v1.0.3 Alpha - (4/1/2012)";

	/**
	 * The color that is read as transparent.
	 */
	public final static Color TRANSPARENT = new Color(255, 0, 234);

	/**
	 * Are we debugging the game?
	 */
	public final static boolean isDebugging = true;

	/**
	 * The default screen height.
	 */
	public final static int SCREEN_HEIGHT = 600;

	/**
	 * The default screen width.
	 */
	public final static int SCREEN_WIDTH = 800;

	/**
	 * The current screen height.
	 */
	public static int CURRENT_SCREEN_HEIGHT = 600;

	/**
	 * The current screen width.
	 */
	public static int CURRENT_SCREEN_WIDTH = 800;

	/**
	 * The width of the in game map.
	 */
	public static final int MAP_WIDTH = 100;

	/**
	 * The height of the in game map.
	 */
	public static final int MAP_HEIGHT = 100;

	/**
	 * The path to where we load our resources.
	 */
	public static final String RESOURCE_PATH = "data/";

	/**
	 * Random names...
	 */
	public static final String[] CHARACTER_NAMES = { "Bob", "Tom", "Dave",
			"Alan", "Alex", "Sarah", "Rachel", "Jessica", "Katie" };
}