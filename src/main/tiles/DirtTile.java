package main.tiles;

import graphics.Assets;
import main.worlds.World;

public class DirtTile extends Tile{
	
	public DirtTile(int id){
		super(Assets.dirt, id);
	}
	
	public void action(World world, int x, int y){
		System.out.println("looks like you activated a dirt tile");
		world.setTile(x, y, 0);
	}

}
