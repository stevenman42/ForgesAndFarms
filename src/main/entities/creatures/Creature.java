package main.entities.creatures;

import main.Game;
import main.entities.Entity;
import main.tiles.Tile;
import main.worlds.World;

public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final int DEFAULT_SPEED = 16;
	public static final int DEFAULT_CREATURE_WIDTH = 16,
							DEFAULT_CREATURE_HEIGHT = 16;
	
	protected int health;
	protected int speed;
	
	protected float xMove, yMove;
	protected World world;

	public Creature(Game game, World world, float x, float y, int width, int height, int id) {
		super(game, world, x, y, width, height, id);
		this.world = world;
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move(int deltaX, int deltaY){
		//System.out.println("x: " + x + " y: " + y);
		if (!World.getTile((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid() &&
				!World.getEntity((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid()){
			x += deltaX;
			y += deltaY;
			tileX = (int) (x / Tile.TILE_WIDTH);
			tileY = (int) (y / Tile.TILE_HEIGHT);

		}
		
		// if it's solid but also pushable
		else if ((World.getEntity((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid()) && ((World.getEntity((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isPushable()))){

			boolean moved = false;
			
			tileX = (int) (x / Tile.TILE_WIDTH);
			tileY = (int) (y / Tile.TILE_HEIGHT);
			if (deltaX == 0){
				if (World.getEntity(tileX, (int) (tileY + (deltaY / Tile.TILE_HEIGHT))).getId() == 0)
					World.getTile(tileX, (int) (tileY + (deltaY / Tile.TILE_HEIGHT))).action(world, tileX, (int)(tileY + deltaY / Tile.TILE_HEIGHT) );
				else{
					moved = (World.getEntity(tileX, (int) (tileY + (deltaY / Tile.TILE_HEIGHT)))).action(world, tileX, (int) (tileY + (deltaY / Tile.TILE_HEIGHT)), deltaY / Math.abs(deltaY));
				}
				
			}
			else if (deltaY == 0){
				System.out.println("it's 0");
				if (World.getEntity((tileX / Tile.TILE_WIDTH), (int) tileY).getId() != 0)
					World.getTile((int) (tileX + deltaX / Tile.TILE_WIDTH) , (int) tileY).action(world, (int) (tileX + deltaX / Tile.TILE_WIDTH), tileY);
				else{
					moved = (World.getEntity(tileX + deltaX / Tile.TILE_WIDTH, tileY)).action(world, (tileX + deltaX / Tile.TILE_WIDTH), tileY, (deltaX / Math.abs(deltaX)) * 2);
				}
			}
			if (moved){
				x += deltaX;
				y += deltaY;
			}
		}
		
		// if it's solid and not pushable
		else if ((World.getTile((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid()) || (World.getEntity((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid())){
			tileX = (int) (x / Tile.TILE_WIDTH);
			tileY = (int) (y / Tile.TILE_HEIGHT);
			if (deltaX == 0){
				if (World.getEntity(tileX, (int) (tileY + (deltaY / Tile.TILE_HEIGHT))).getId() == 0){
					World.getTile(tileX, (int) (tileY + (deltaY / Tile.TILE_HEIGHT))).action(world, tileX, (int)(tileY + deltaY / Tile.TILE_HEIGHT) );
				}
				else{
					(World.getEntity(tileX, (int) (tileY + (deltaY / Tile.TILE_HEIGHT)))).action(world, tileX, (int) (tileY + (deltaY / Tile.TILE_HEIGHT)), deltaY / Math.abs(deltaY));
				}
				
			}
			else if (deltaY == 0){
				System.out.println("it's 0");
				if (World.getEntity((tileX / Tile.TILE_WIDTH), (int) tileY).getId() != 0)
					World.getTile((int) (tileX + deltaX / Tile.TILE_WIDTH) , (int) tileY).action(world, (int) (tileX + deltaX / Tile.TILE_WIDTH), tileY);
				else{
					(World.getEntity(tileX + deltaX / Tile.TILE_WIDTH, tileY)).action(world, (tileX + deltaX / Tile.TILE_WIDTH), tileY, (deltaX / Math.abs(deltaX)) * 2);
				}
			}
		}
	}
	
//	public void move(float deltaX, float deltaY){
//		if (!world.getTile((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid() &&
//				!World.getEntity((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid()){
//			x += deltaX;
//			y += deltaY;
//			tileX = (int) (x / Tile.TILE_WIDTH);
//			tileY = (int) (y / Tile.TILE_HEIGHT);
//		}
//		else if ((world.getTile((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid())){
//			if (deltaX == 0){
//				world.getTile((int) tileX, (int) (tileY + (deltaY / Tile.TILE_HEIGHT))).action(world, tileX, (int)(tileY + deltaY / Tile.TILE_HEIGHT) );
//			}
//			else if (deltaY == 0){
//				world.getTile((int) (tileX + deltaX / Tile.TILE_WIDTH) , (int) tileY).action(world, (int) (tileX + deltaX / Tile.TILE_WIDTH), tileY);
//			}
//		}
//	}
	
	
	public int getHealth(){
		return health;
	}
	public void setHealth(int health){
		this.health = health;
	}
	
	public float getSpeed(){
		return speed;
	}
	
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	public float getxMove(){
		return xMove;
	}
	
	public void setxMove(float xMove){
		this.xMove = xMove;
	}
	
	public float getyMove(){
		return yMove;
	}
	
	public void setyMove(float yMove){
		this.yMove = yMove;
	}
	

}
