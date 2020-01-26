package com.nightleaf.world.tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import com.nightleaf.world.Tile;
import com.nightleaf.world.World;

public class SandTile extends Tile {

	public SandTile() {
		super(1);
	}

	@Override
	public void init() {
		sandColors = new Color[1];
		sandColors[0] = new Color(246, 251, 170);
		if (tileColor == null)
			setColor(sandColors[0]);
	}

	@Override
	public void render(Graphics g) {
		if (World.tileSprites[1] != null) {
			g.drawImage(World.tileSprites[1], posX * 8 + World.offsetX, posY
					* 8 + World.offsetY, tileColor);
		}
	}

	@Override
	public void update() {

	}

	private Color[] sandColors;
}
