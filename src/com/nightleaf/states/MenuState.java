package com.nightleaf.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.nightleaf.Config;

public class MenuState extends BasicGameState implements MouseListener {

	@Override
	@SuppressWarnings("unchecked")
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		menuButtonsHL = new boolean[3];
		menuButtons = new Image[2];
		menuButtons[0] = new Image(Config.RESOURCE_PATH
				+ "sprites/buttons/MenuButtons0.png");
		menuButtons[1] = new Image(Config.RESOURCE_PATH
				+ "sprites/buttons/MenuButtons1.png");
		gameLogo = new Image(Config.RESOURCE_PATH + "sprites/logo.png");
		menuFonts = new UnicodeFont[2];
		menuFonts[0] = new UnicodeFont(Config.RESOURCE_PATH
				+ "fonts/5x5_pixel.ttf", 16, false, false);
		menuFonts[1] = new UnicodeFont(Config.RESOURCE_PATH
				+ "fonts/pixeljosh6.ttf", 12, false, false);
		for (int i = 0; i < menuFonts.length; i++) {
			menuFonts[i].getEffects()
					.add(new ColorEffect(java.awt.Color.white));
			menuFonts[i].addAsciiGlyphs();
			menuFonts[i].loadGlyphs();
		}
		menuStrings = new String[3];
		menuStrings[0] = "Play";
		menuStrings[1] = "Options";
		menuStrings[2] = "Exit";
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		drawBackground(g);
		drawMenu(container, g, 3);
		drawLogo(container, g);
		drawVersion(g);
		drawDebug(g);
	}

	/**
	 * Draws information that will help the developers.
	 * 
	 * @param g
	 */
	private void drawDebug(Graphics g) {
		if (Config.isDebugging) {
			g.drawString("MouseX: " + mouseX + ", MouseY: " + mouseY, 10, 30);
			g.drawString(debugString, 10, 60);
		}
	}

	/**
	 * Draws the main menu.
	 * 
	 * @param g
	 */
	private void drawMenu(GameContainer container, Graphics g, int buttonAmount) {
		int offset = 0;
		for (int i = 0; i < buttonAmount; i++) {
			menuButtons[0].draw(
					(Config.CURRENT_SCREEN_WIDTH / 2 - menuButtons[0]
							.getWidth() / 2), (Config.CURRENT_SCREEN_HEIGHT / 2
							- menuButtons[0].getHeight() / 2 - offset));
			offset -= 45;
		}
		if (menuButtonsHL[0]) {
			menuButtons[1].draw(
					(Config.CURRENT_SCREEN_WIDTH / 2 - menuButtons[1]
							.getWidth() / 2),
					(Config.CURRENT_SCREEN_HEIGHT / 2 - menuButtons[1]
							.getHeight() / 2));
		} else if (menuButtonsHL[1]) {
			menuButtons[1].draw(
					(Config.CURRENT_SCREEN_WIDTH / 2 - menuButtons[1]
							.getWidth() / 2), (Config.CURRENT_SCREEN_HEIGHT / 2
							- menuButtons[1].getHeight() / 2 + 45));
		} else if (menuButtonsHL[2]) {
			menuButtons[1].draw(
					(Config.CURRENT_SCREEN_WIDTH / 2 - menuButtons[1]
							.getWidth() / 2), (Config.CURRENT_SCREEN_HEIGHT / 2
							- menuButtons[1].getHeight() / 2 + 90));
		}
		int fontOffset = 0;
		for (int i = 0; i < menuStrings.length; i++) {
			int x = Config.CURRENT_SCREEN_WIDTH / 2
					- menuFonts[0].getWidth(menuStrings[i]) / 2;
			int y = Config.CURRENT_SCREEN_HEIGHT / 2
					- menuFonts[0].getHeight(menuStrings[i]) / 2;
			menuFonts[0].drawString(x, y - fontOffset, menuStrings[i]);
			fontOffset -= 45;
		}
	}

	/**
	 * Draws the game's logo.
	 * 
	 * @param container
	 * @param g
	 */
	private void drawLogo(GameContainer container, Graphics g) {
		int offset = 100;
		gameLogo.draw(
				(Config.CURRENT_SCREEN_WIDTH / 2 - gameLogo.getWidth() / 2),
				(Config.CURRENT_SCREEN_HEIGHT / 2 - gameLogo.getHeight() / 2 - offset));
	}

	/**
	 * Draws the games version in the corner.
	 * 
	 * @param g
	 */
	private void drawVersion(Graphics g) {
		int offsetX = 0;
		int offsetY = 0;
		offsetX += 313;
		offsetY -= 285;
		int x = Config.CURRENT_SCREEN_WIDTH / 2
				- menuFonts[1].getWidth(Config.GAME_VERSION) / 2;
		int y = Config.CURRENT_SCREEN_HEIGHT / 2
				- menuFonts[1].getHeight(Config.GAME_VERSION) / 2;
		menuFonts[1].drawString(x - offsetX, y - offsetY, Config.GAME_VERSION);
	}

	/**
	 * Draws the background for the menu state.
	 * 
	 * @param g
	 */
	private void drawBackground(Graphics g) {
		g.setBackground(new Color(20, 54, 0));
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		Config.CURRENT_SCREEN_HEIGHT = container.getHeight();
		Config.CURRENT_SCREEN_WIDTH = container.getWidth();
		Input input = container.getInput();
		handleMouseInput(game, container, input);

	}

	/**
	 * Handles all mouse input for the menu state.
	 * 
	 * @param input
	 */
	public void handleMouseInput(StateBasedGame game, GameContainer container,
			Input input) {
		mouseX = input.getAbsoluteMouseX();
		mouseY = input.getAbsoluteMouseY();
		int originX = Config.CURRENT_SCREEN_WIDTH / 2;
		int originY = Config.CURRENT_SCREEN_HEIGHT / 2;
		int buttonOriginX = originX - menuButtons[0].getWidth() / 2;
		int buttonOriginY = originY - menuButtons[0].getHeight() / 2;
		int offset = 0;
		if (mouseX >= buttonOriginX && mouseY >= buttonOriginY
				&& mouseX <= buttonOriginX + 170
				&& mouseY <= buttonOriginY + 35) {
			menuButtonsHL[0] = true;
			menuButtonsHL[1] = false;
			menuButtonsHL[2] = false;
		} else {
			menuButtonsHL[0] = false;
		}
		offset -= 45;
		if (mouseX >= buttonOriginX && mouseY >= buttonOriginY - offset
				&& mouseX <= buttonOriginX + 170
				&& mouseY <= buttonOriginY + 35 - offset) {
			menuButtonsHL[1] = true;
			menuButtonsHL[0] = false;
			menuButtonsHL[2] = false;
		} else {
			menuButtonsHL[1] = false;
		}
		offset -= 45;
		if (mouseX >= buttonOriginX && mouseY >= buttonOriginY - offset
				&& mouseX <= buttonOriginX + 170
				&& mouseY <= buttonOriginY + 35 - offset) {
			menuButtonsHL[2] = true;
			menuButtonsHL[1] = false;
			menuButtonsHL[0] = false;
		} else {
			menuButtonsHL[2] = false;
		}
		handleMenuButtons(game);
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		mousePressedX = x;
		mousePressedY = y;
		int offset = 0;
		int originX = Config.CURRENT_SCREEN_WIDTH / 2;
		int originY = Config.CURRENT_SCREEN_HEIGHT / 2;
		int buttonOriginX = originX - menuButtons[0].getWidth() / 2;
		int buttonOriginY = originY - menuButtons[0].getHeight() / 2;
		// Play
		if (mousePressedX >= buttonOriginX && mousePressedY >= buttonOriginY
				&& mousePressedX <= buttonOriginX + 170
				&& mousePressedY <= buttonOriginY + 35) {
			playState = true;
		}
		offset -= 45;
		// Options
		if (mousePressedX >= buttonOriginX && mousePressedY >= buttonOriginY
				&& mousePressedX <= buttonOriginX + 170
				&& mousePressedY <= buttonOriginY + 35 - offset) {
			optionState = true;
		}
		offset -= 45;
		// Exit
		if (mousePressedX >= buttonOriginX && mousePressedY >= buttonOriginY
				&& mousePressedX <= buttonOriginX + 170
				&& mousePressedY <= buttonOriginY + 35 - offset) {
			if (!playState && !optionState)
				System.exit(0);
		}
	}

	/**
	 * Handles the button input for the main menu.
	 * 
	 * @param pressedX
	 * @param pressedY
	 */
	private void handleMenuButtons(StateBasedGame game) {
		if (playState) {
			game.enterState(1);
			return;
		} else if (optionState) {

			return;
		}
	}

	@Override
	public int getID() {
		return 0;
	}

	private final String debugString = "";
	private String[] menuStrings;
	private UnicodeFont[] menuFonts;
	private boolean playState;
	private boolean optionState;
	private boolean[] menuButtonsHL;
	private Image[] menuButtons;
	private Image gameLogo;
	private int mouseX, mouseY;
	private int mousePressedX, mousePressedY;
}
