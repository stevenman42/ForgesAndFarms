package main.tiles;

import graphics.Assets;
import main.entities.Entity;
import main.inventory.Inventory;
import main.worlds.World;

public class TilledDirtTile extends Tile{
	
	public TilledDirtTile(int id){
		super(Assets.tilledDirt, id);
	}
	
	public void action(World world, int x, int y){
		if (Inventory.getActiveItem() == null)
			super.action(world, x, y);
		else{
			// if you put something on a tilled dirt tile, it turns it back into dirt
			if ((world.getEntity(x, y) == null || world.getEntity(x, y).getClass() == Entity.entities[0].getClass()))
				world.setTile(x, y, 1);
			else
				super.action(world, x, y);
		}
	}
	

}
