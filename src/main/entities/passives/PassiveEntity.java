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
	protected float x, y;
	
	public boolean onGround = true;
	


	public PassiveEntity(Game game, World world, float x, float y, int width, int height, int id) {
		super(game, world, x, y, width, height, id);

	}
	
	public PassiveEntity(BufferedImage texture, int id){
		super(texture, id);
	}

	
	@Override
	public void tick() {
	}


	
	

}
