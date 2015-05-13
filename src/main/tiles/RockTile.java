package main.tiles;

import graphics.Assets;
import main.worlds.World;

public class RockTile extends Tile{
	
	private int health = 5; // when this goes down to 0, the block breaks
	
	public RockTile(int id){
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
	public void action(World world, int x, int y){
		System.out.println("Looks like you activated a rock!");
		
		if (health == 0){
			world.setTile(x, y, 1);
		}
		else
			health --;
		
	}
	
	public Tiles getId(){
		return Tiles.rock;
	}

}
