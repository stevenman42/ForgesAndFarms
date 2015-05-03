package main.tiles;

import graphics.Assets;
import main.worlds.World;

public class TilledDirtTile extends Tile{
	
	public TilledDirtTile(int id){
		super(Assets.tilledDirt, id);
	}
	
	public void action(World world, int x, int y){
		world.setTile(y, x, 0);
	}

}
