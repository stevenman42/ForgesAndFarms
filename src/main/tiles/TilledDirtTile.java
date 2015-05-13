package main.tiles;

import graphics.Assets;
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
		else
			System.out.println("You can't place a fence on a tilled dirt tile silly");
	}
	
	public Tiles getId(){
		return Tiles.tilledDirt;
	}

}
