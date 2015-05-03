package main.entities;

import java.awt.Graphics;

import main.Game;
import main.tiles.Tile;
import main.worlds.World;

public abstract class Entity {
	
	protected float x, y;
	protected int tileX, tileY;
	protected int width, height;
	protected Game game;
	protected World world;
	
	public Entity(Game game, World world, float x, float y, int width, int height){
		this.game = game;
		this.x = x;
		this.y = y;
		this.tileX = (int) (x / Tile.TILE_WIDTH);
		this.tileY = (int) (y / Tile.TILE_HEIGHT);
		this.width = width;
		this.height = height;
		this.world = world;
	}
	
	
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	
	// returns the tile that the entity is current on
	// if, for some reason, the entity takes up more that one tile, I think it returns the one that the origin of the entity is on
	public Tile getCurrentTile(){
		return world.getTile((int) (x / Tile.TILE_WIDTH), (int) (y / Tile.TILE_HEIGHT));
	}
	
	public int getXPosition(){
		return (int) (x / Tile.TILE_WIDTH);
	}
	
	public int getYPosition(){
		return (int) (y / Tile.TILE_HEIGHT);
	}



	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
