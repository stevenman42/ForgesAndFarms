package main.entities.passives;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import main.entities.Entity;
import main.tiles.Tile;
import main.worlds.World;

public class PassiveEntity extends Entity{
	
	protected BufferedImage texture;
	private int width, height;
	private float x, y;
	
	public boolean onGround = true;

	public PassiveEntity(Game game, World world, float x, float y, int width, int height) {
		super(game, world, x, y, width, height);
		this.x = 50;
		this.y = 50;
		texture = Assets.player;

	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		if (onGround) {g.drawImage(Assets.player, (int) y, (int) x, 16, 16, null);}
	}
	
	

}
