package main.tiles;

import graphics.Assets;
import main.worlds.World;

public class DirtTile extends Tile{
	
	public DirtTile(int id){
		super(Assets.dirt, id);
	}
	
	public void action(World world, int x, int y){
		world.setTile(y, x, 2);
	}

}
