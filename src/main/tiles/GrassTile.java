package main.tiles;

import graphics.Assets;
import main.worlds.World;

public class GrassTile extends Tile{
	
	public GrassTile(int id){
		
		super(Assets.grass, id);
		
	}
	
	public void action(World world, int x, int y){
		if(world.getEntity(x, y) == null){
			world.setTile(x, y, 1);
		}
		else
			world.getEntity(y, x).action(world, x, y);
	}

}
