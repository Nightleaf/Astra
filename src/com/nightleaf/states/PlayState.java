package com.nightleaf.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.nightleaf.Config;
import com.nightleaf.entity.Player;
import com.nightleaf.world.World;

public class PlayState extends BasicGameState {

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		World.init(container);
		myPlayer = new Player();
		myPlayer.init(container);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		World.renderWorld(g);
		myPlayer.render(g);
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
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		Config.CURRENT_SCREEN_HEIGHT = container.getHeight();
		Config.CURRENT_SCREEN_WIDTH = container.getWidth();
		Input input = container.getInput();
		mouseX = input.getAbsoluteMouseX();
		mouseY = input.getAbsoluteMouseY();
		World.updateWorld();
		myPlayer.update(container);
	}

	@Override
	public int getID() {
		return 1;
	}

	private Player myPlayer;
	private int mouseX, mouseY;
}
