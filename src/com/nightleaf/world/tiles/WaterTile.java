package com.nightleaf.world.tiles;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import com.nightleaf.world.Tile;
import com.nightleaf.world.World;

public class WaterTile extends Tile {

	public WaterTile() {
		super(2);
	}

	@Override
	public void init() {
		if (tileColor == null)
			setColor(new Color(68, 121, 201));
	}

	@Override
	public void render(Graphics g) {
		if (World.tileSprites[2] != null) {
			g.drawImage(World.tileSprites[2], posX * 8 + World.offsetX, posY
					* 8 + World.offsetY, tileColor);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
