package main.tiles;

import graphics.Assets;
import main.entities.Entity;
import main.entities.passives.PassiveEntity;
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
			if ((world.getEntity(x, y) == null || world.getEntity(x, y).getClass() == Entity.entities[0].getClass()))
				System.out.println("You can't place a fence on a tilled dirt tile silly");
			else
				super.action(world, x, y);
		}
	}
	
	public Tiles getId(){
		return Tiles.tilledDirt;
	}

}
