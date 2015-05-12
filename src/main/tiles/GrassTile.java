package main.tiles;

import graphics.Assets;
import main.entities.passives.PassiveEntity;
import main.worlds.World;

public class GrassTile extends Tile{
	
	public GrassTile(int id){
		
		super(Assets.grass, id);
		
	}
	
	public void action(World world, int x, int y){
		if(world.getEntity(x, y) == null || world.getEntity(x, y).getId() == 0){
			// changes the tile to dirt if there isn't an entity on the tile
			world.setTile(x, y, 1);
		}
		else{
			((PassiveEntity) world.getEntity(x, y)).action(world, x, y);
			System.out.println("main.tiles.GrassTile.java: activated the thing");
		}
	}
	
	public Tiles getId(){
		return Tiles.dirt;
	}

}
