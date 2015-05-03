package main.tiles;

import graphics.Assets;
import main.worlds.World;

public class DirtTile extends Tile{
	
	public DirtTile(int id){
		super(Assets.dirt, id);
	}
	
	public void action(World world){
		System.out.println("looks like you activated a dirt tile");
		world.setTile(100, 100, new GrassTile(1));
	}

}
