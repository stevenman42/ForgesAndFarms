package main.tiles;

import graphics.Assets;
import main.worlds.World;

public class GrassTile extends Tile{
	
	public GrassTile(int id){
		
		super(Assets.grass, id);
		
	}
	
	public void action(World world, int x, int y){
		world.setTile(y, x, 1);
	}

}
