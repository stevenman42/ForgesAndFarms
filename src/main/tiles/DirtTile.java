package main.tiles;

import graphics.Assets;
import main.worlds.World;

public class DirtTile extends Tile{
	
	public DirtTile(int id){
		super(Assets.dirt, id);
	}
	
	public void action(World world, int x, int y){
		if(world.getEntity(x, y) == null){
			world.setTile(x, y, 1);
		}
		else
			world.getEntity(x, y).action(world, x, y);
	}


}