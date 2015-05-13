package main.tiles;

import java.awt.Graphics;

import main.entities.Entity;
import main.entities.passives.*;
import main.inventory.Inventory;

import java.awt.image.BufferedImage;

import main.worlds.World;

public abstract class Tile {
	
	// static stuff
	
	public static Tile[] tiles = new Tile[256]; // this is the number of different types of tiles
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile tilledDirtTile = new TilledDirtTile(2);
	public static Tile rockTile = new RockTile(3);
	
	
	// class
	
	public static final int TILE_WIDTH = 16, TILE_HEIGHT = 16;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
		
	}
	
	public void action(World world, int x, int y){
		//System.out.println("the active item is: " + Inventory.getActiveItem());
		//System.out.println("called the action method in the Tile class (Tile.java)");
		// makes sure that there is an entity selected in the inventory, and that there isn't an entity on the ground
		if (Inventory.getActiveItem() != null && Inventory.getActiveItem().getClass() != Entity.entities[0].getClass() &&
				(world.getEntity(x, y).getClass() == Entity.entities[0].getClass() || world.getEntity(x, y) == null)){
			world.setEntity(x, y, ((Entity) Inventory.getActiveItem()).getId());
		}
		else if(world.getEntity(x, y) == null || world.getEntity(x, y).getId() == 0){
			// changes the tile if there isn't an entity on the tile
			if (id == 0)
				world.setTile(x, y, 1);
			else if (id == 1)
				world.setTile(x, y, 2);
			else if (id == 2)
				world.setTile(x, y, 0);
			else
				world.setTile(x, y, id);
		}

		else{
			((PassiveEntity) world.getEntity(x, y)).action(world, x, y);
		}
	}
	public void placeTile(World world, int x, int y, int id){
		world.setTile(x, y, id);
	}
	
	
	public void tick(){
		
	}
	
	
	
	public void render(Graphics g, int x, int y){
		
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
		
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public abstract Tiles getId();

}
