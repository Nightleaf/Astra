package com.nightleaf;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.nightleaf.states.MenuState;
import com.nightleaf.states.PlayState;

public class Game extends StateBasedGame {

	public Game() {
		super("Astra");
	}

	public void initStatesList(GameContainer container) throws SlickException {
		addState(new MenuState());
		addState(new PlayState());
	}

	public static void main(String[] args) {
		try {
			AppGameContainer container = new AppGameContainer(new Game());
			container.setDisplayMode(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT,
					false);
			container.setTargetFrameRate(60);
			if (!Config.isDebugging)
				container.setVerbose(false);			
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
