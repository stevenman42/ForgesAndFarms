package main.entities.creatures;

import main.Game;
import main.entities.Entity;
import main.tiles.Tile;
import main.worlds.World;

public abstract class Creature extends Entity{
	
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 16.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 16,
							DEFAULT_CREATURE_HEIGHT = 16;
	
	protected int health;
	protected float speed;
	
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
		if (!world.getTile((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid()){
			x += deltaX;
			y += deltaY;
			tileX = (int) (x / Tile.TILE_WIDTH);
			tileY = (int) (y / Tile.TILE_HEIGHT);
		}
	}
	
	public void move(float deltaX, float deltaY){
		if (!world.getTile((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid()){
			x += deltaX;
			y += deltaY;
			tileX = (int) (x / Tile.TILE_WIDTH);
			tileY = (int) (y / Tile.TILE_HEIGHT);
		}
		else if ((world.getTile((int)((x + deltaX) / Tile.TILE_WIDTH), (int)((y + deltaY) / Tile.TILE_HEIGHT)).isSolid())){
			if (deltaX == 0){
				world.getTile((int) tileX, (int) (tileY + (deltaY / Tile.TILE_HEIGHT))).action(world, tileX, (int)(tileY + deltaY / Tile.TILE_HEIGHT) );
			}
			else if (deltaY == 0){
				world.getTile((int) (tileX + deltaX / Tile.TILE_WIDTH) , (int) tileY).action(world, (int) (tileX + deltaX / Tile.TILE_WIDTH), tileY);
			}
		}
	}
	
	
	public int getHealth(){
		return health;
	}
	public void setHealth(int health){
		this.health = health;
	}
	
	public float getSpeed(){
		return speed;
	}
	
	public void setSpeed(float speed){
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
