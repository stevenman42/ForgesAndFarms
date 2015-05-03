package main.tiles;

import graphics.Assets;
import main.worlds.World;

public class RockTile extends Tile{
	
	public RockTile(int id){
		super(Assets.stone, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}
	
	public void action(World world){
		System.out.println("Looks like you activated a rock!");
	}

}
