package main.entities.creatures;

import graphics.Assets;
import graphics.hud.InventoryBar;

import java.awt.Graphics;

import main.Game;
import main.entities.passives.WireEntity;
//import main.KeyManager;
//import main.entities.Entity;
//import main.entities.passives.NullEntity;
import main.inventory.Inventory;
import main.tiles.Tile;
import main.worlds.World;

public class Player extends Creature{

	private float centerX, centerY;
	
	private int xWindowRange = 15; // the number of tiles that you can go in the x direction before the camera starts moving after you
	private int yWindowRange = 7; // the same number as above pretty much, but for y instead of x

	public static boolean moved = false;
	
	public Player(Game game, World world, float x, float y) {
		super(game, world, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, 0);
		// the player has the Entity id of 0
	
		Game.getGameCamera().centerOnEntity(this);
		centerY = y * Tile.TILE_HEIGHT;
		centerX = x * Tile.TILE_WIDTH;
	}

//	public Entity getCurrentEntity(){
//		return world.getEntity((int) (x / Tile.TILE_WIDTH),(int) (y / Tile.TILE_HEIGHT));
//	}

	@Override
	public void tick() {
		
		getInput();
		
		if (x - centerX > (xWindowRange * Tile.TILE_WIDTH)){
			Game.getGameCamera().move(Tile.TILE_WIDTH, 0);
			centerX += Tile.TILE_WIDTH;
		}
	
		if (x - centerX < (-xWindowRange * Tile.TILE_WIDTH)){
			Game.getGameCamera().move(-Tile.TILE_WIDTH, 0);
			centerX -= Tile.TILE_WIDTH;
		}
		
		if (y - centerY > (yWindowRange * Tile.TILE_HEIGHT)){
			Game.getGameCamera().move(0, Tile.TILE_HEIGHT);
			centerY += Tile.TILE_HEIGHT;
		}
		
		if (y - centerY < (-yWindowRange * Tile.TILE_HEIGHT)){
			Game.getGameCamera().move(0, -Tile.TILE_HEIGHT);
			centerY -= Tile.TILE_HEIGHT;
		}
	}
	
	
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		
		if (game.getKeyManager().up){

			if (!moved){
				if (y - speed - 1< 0){
					World.addRow("top");
					moved = true;
				}
				else{
					//System.out.println("going up");
					move(0, -speed);
					moved = true;
				}
			}
		}
		if (game.getKeyManager().down){

			if (!moved){
				move(0, speed);
				moved = true;
				
				// if you're about to go below the end of the world, it adds more stuff to the world
				if (y + speed + 1 > World.getHeight() * Tile.TILE_HEIGHT){
					World.addRow("bottom");
				}
			}
		}
		if (game.getKeyManager().left){

			if(!moved){
				if (x - speed - 1 < 0){
					World.addColumn("left");
					moved = true;
				}
				else{
					move(-speed, 0);
					moved = true;
				}
			}
		}
		if (game.getKeyManager().right){

			if (!moved){
				if (x + speed + Tile.TILE_WIDTH * 2 > World.getWidth() * Tile.TILE_WIDTH){
					World.addColumn("right");
				}
				else{
					move(speed, 0);
					moved = true;
				}
			}
		}
		
		if (game.getKeyManager().space){
			if (!moved){
				if (getCurrentEntity().getId() != 0){
					Inventory.changeItem(getCurrentEntity());
				}
				getCurrentTile().action(world, (int)(x / Tile.TILE_WIDTH), (int)(y / Tile.TILE_HEIGHT));
				
				// YES I KNOW THIS IS A TERRIBLE WAY TO DO IT ARGH
				if(getCurrentEntity().getId() == 5 || getCurrentEntity().getId() == 6)
					WireEntity.updateWire();
				
				moved = true;
				
				// this prints the contents of the inventory
				
				/*
				for (int i = 0; i < 10; i ++){
					if (Inventory.getItem(i) != null && Inventory.getItem(i).getClass() == Entity.entities[1].getClass()){
						System.out.print("wood_fence ");
					}
					else if (Inventory.getItem(i) != null && Inventory.getItem(i).getClass() == Entity.entities[2].getClass()){
						System.out.print("stone_fence ");
					}
					else
						System.out.print(Inventory.getItem(i) + " ");
				}
				System.out.println();
				*/
			}
		}
		
		if(game.getKeyManager().one){
				InventoryBar.setActiveSlot(1);
		}
		if(game.getKeyManager().two){
				InventoryBar.setActiveSlot(2);
		}
		if(game.getKeyManager().three){
				InventoryBar.setActiveSlot(3);
		}
		if(game.getKeyManager().four){
				InventoryBar.setActiveSlot(4);
		}
		if(game.getKeyManager().five){
				InventoryBar.setActiveSlot(5);
		}
		if(game.getKeyManager().six){
				InventoryBar.setActiveSlot(6);
		}
		if(game.getKeyManager().seven){
				InventoryBar.setActiveSlot(7);
		}
		if(game.getKeyManager().eight){
				InventoryBar.setActiveSlot(8);
		}
		if(game.getKeyManager().nine){
				InventoryBar.setActiveSlot(9);
		}
		if(game.getKeyManager().zero){
				InventoryBar.setActiveSlot(0);
		}
		
		if(game.getKeyManager().escape){
			System.out.println("Closing...");
			System.exit(64);
		}
	
		
	}

	public void render(Graphics g) {
		
		g.drawImage(Assets.player, (int) (x - Game.getGameCamera().getxOffset()), (int) (y - Game.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public boolean action(World world, int x, int y, int code) {
		return false;
		
	}

	

}
