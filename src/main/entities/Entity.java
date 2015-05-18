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
	public static Entity woodWallEntity = new WoodFenceEntity(1);
	public static Entity stoneWallEntity = new StoneFenceEntity(2);
	public static Entity woodBoxEntity = new WoodBoxEntity(3);
	public static Entity wireEntity = new WireEntity(5);
	public static Entity nullEntity = new NullEntity(0);
	
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
		if (id != 0){
			this.width = 16;
			this.height = 16;
		}
		entities[id] = this;
	}
	
	
	
	public abstract void tick();
	
	public void render(Graphics g, int x, int y){
		if (id != 0)
			g.drawImage(texture, x, y, width, height, null);
	}
	
//	public void move(int deltaX, int deltaY){
//		System.out.println("x: " + x + " y: " + y);
//		if ((World.getTile((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)) != null) && !World.getTile((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid() &&
//				!World.getEntity((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid()){
//			x += deltaX;
//			y += deltaY;
//			tileX = (int) (x / Tile.TILE_WIDTH);
//			tileY = (int) (y / Tile.TILE_HEIGHT);
//		}
//		else
//			System.out.println("nope");
//	}
	
	public boolean move(int x, int y, int deltaX, int deltaY){
		//System.out.println("x: " + x + " y: " + y);
		if (World.getEntity(x+ deltaX, y + deltaY).getId() == 0){
			World.setEntity(x, y, 0);
			World.setEntity(x + deltaX, y + deltaY, id);
			return true;
		}
		
		return false;
	}
	
	
	
	// returns the tile that the entity is current on
	// if, for some reason, the entity takes up more that one tile, I think it returns the one that the origin of the entity is on
	public Tile getCurrentTile(){
		//System.out.println("the tile at x position: " + x + " and y position: " + y + " is " + world.getTile((int) (x / Tile.TILE_WIDTH), (int) (y / Tile.TILE_HEIGHT)));
		return World.getTile((int) (x / Tile.TILE_WIDTH), (int) (y / Tile.TILE_HEIGHT));
	}
	
	public Entity getCurrentEntity(){
		//System.out.println("the entity at x position: " + x + " and y position: " + y + "  is " + world.getEntity((int)(x / Tile.TILE_WIDTH), (int) (y / Tile.TILE_HEIGHT)));
		return World.getEntity((int)(x / Tile.TILE_WIDTH), (int) (y / Tile.TILE_HEIGHT));
	}
	
	public int getXPosition(){
		return (int) (x / Tile.TILE_WIDTH);
	}
	
	public int getYPosition(){
		return (int) (y / Tile.TILE_HEIGHT);
	}

	public int getId(){
		return id;
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
	
	// this method always returns false because that's the default
	// if it needs to return anything else, then it should be overriden in a subclass
	public boolean isSolid(){
		return false;
	}
	
	public boolean isPushable(){
		return false;
	}


	public abstract boolean action(World world, int x, int y, int code);
}
