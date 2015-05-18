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

		// makes sure that there is an entity selected in the inventory, and that there isn't an entity on the ground
		if (Inventory.getActiveItem() != null && Inventory.getActiveItem().getClass() != Entity.entities[0].getClass() &&
				(World.getEntity(x, y).getClass() == Entity.entities[0].getClass() || World.getEntity(x, y) == null)){
			try{
				World.setEntity(x, y, ((Entity) Inventory.getActiveItem()).getId());
			}catch(ClassCastException e){
				world.setTile(x, y, ((Tile) Inventory.getActiveItem()).getId());
			}
		}
		else if(World.getEntity(x, y) == null || World.getEntity(x, y).getId() == 0){
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
			((Entity) World.getEntity(x, y)).action(world, x, y, 1);
			System.out.println("this is the thing that I'm calling");
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
	
	public int getId(){
		return id;
	}

}
