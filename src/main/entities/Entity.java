package main.entities;

import java.awt.Graphics;

import main.Game;
import main.tiles.Tile;

public abstract class Entity {
	
	protected float x, y;
	protected int width, height;
	protected Game game;
	
	public Entity(Game game, float x, float y, int width, int height){
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
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
