package main.entities;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import main.entities.passives.*;
import main.tiles.Tile;
import main.worlds.World;

public abstract class Entity {
	
	protected float x, y;
	protected int tileX, tileY;
	protected int width, height;
	protected Game game;
	protected World world;
	
	public static Entity[] entities = new Entity[256]; // this is the number of different types of tiles
	public static Entity woodWall = new WoodFenceEntity(1);
	public static Entity stoneWall = new StoneFenceEntity(2);
	public static Entity nullEntity = new PassiveEntity();
	
	protected BufferedImage texture;
	protected final int id;
	
	
	public Entity(Game game, World world, float x, float y, int width, int height, int id){
		this.id = id;
		this.game = game;
		this.x = x;
		this.y = y;
		this.tileX = (int) (x / Tile.TILE_WIDTH);
		this.tileY = (int) (y / Tile.TILE_HEIGHT);
		this.width = width;
		this.height = height;
		this.world = world;
	}
	
	
	public Entity(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		entities[id] = this;
	}
	
	
	
	public abstract void tick();
	
	public abstract void action(World world, int x, int y);
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, 16, 16, null);
	}
	
	
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
