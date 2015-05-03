package main.entities.passives;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import main.entities.Entity;
import main.tiles.GrassTile;
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

	// I might want to move this stuff up to the Entity class, depending on how the other types of entities are going to act
	public static PassiveEntity[] passEnts = new PassiveEntity[256]; // this is the number of different types of tiles
	//public PassiveEntity woodFence = new FenceEntity(game, world, x, y, width, height, Assets.woodWall);

	
	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		if (onGround) {g.drawImage(Assets.player, (int) y, (int) x, 16, 16, null);}
	}
	
	

}
