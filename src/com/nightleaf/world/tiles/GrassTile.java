package com.nightleaf.world.tiles;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import com.nightleaf.world.Tile;
import com.nightleaf.world.World;

public class GrassTile extends Tile {

	public GrassTile() {
		super(0);
	}

	@Override
	public void init() {
		random = new Random();
		grassColors = new Color[3];
		grassColors[0] = new Color(0, 104, 0);
		grassColors[1] = new Color(0, 115, 0);
		grassColors[2] = new Color(6, 107, 6);
		if (tileColor == null)
			setColor(grassColors[random.nextInt(3)]);
	}

	@Override
	public void render(Graphics g) {
		if (World.tileSprites[0] != null) {

			g.drawImage(World.tileSprites[0], posX * 8 + World.offsetX, posY
					* 8 + World.offsetY, tileColor);
		}
	}

	@Override
	public void update() {

	}

	private Random random;
	private Color[] grassColors;
}
