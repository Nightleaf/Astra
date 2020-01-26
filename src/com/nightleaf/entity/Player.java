package com.nightleaf.entity;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.nightleaf.Config;
import com.nightleaf.world.World;

public class Player extends Entity {

	@Override
	public void init(GameContainer container) throws SlickException {
		rand = new Random();
		name = "nullplayer";
		sprite = new Image(Config.RESOURCE_PATH + "sprites/character/char.png",
				Config.TRANSPARENT);
	}

	@Override
	public void render(Graphics g) throws SlickException {
		absX = (Config.CURRENT_SCREEN_WIDTH / 2 - sprite.getWidth() / 2) / 4;
		absY = (Config.CURRENT_SCREEN_HEIGHT / 2 - sprite.getHeight() / 2) / 4;
		sprite.setFilter(Image.FILTER_NEAREST);
		g.drawImage(sprite, absX, absY);
	}

	@Override
	public void update(GameContainer container) {
		// System.out.println("PlayerX: " + World.offsetX + ", PlayerY: "
		// + World.offsetY);
		Input input = container.getInput();
		if (input.isKeyDown(Keyboard.KEY_W)) {
			if (World.offsetY <= 72)
				World.offsetY += 1;
		}
		if (input.isKeyDown(Keyboard.KEY_S)) {
			if (World.offsetY >= -718)
				World.offsetY -= 1;
		}
		if (input.isKeyDown(Keyboard.KEY_A)) {
			if (World.offsetX <= 99)
				World.offsetX += 1;
		}
		if (input.isKeyDown(Keyboard.KEY_D)) {
			if (World.offsetX >= -693)
				World.offsetX -= 1;
		}
	}

	private int absX;
	private int absY;
	public String name;
	private Image sprite;
	private Random rand;
}
