package main.tiles;

import graphics.Assets;
import graphics.hud.InventoryBar;
import main.entities.passives.PassiveEntity;
import main.worlds.World;

public class DirtTile extends Tile{
	
	public DirtTile(int id){
		super(Assets.dirt, id);
	}
	
	public void action(World world, int x, int y){
		if(world.getEntity(x, y).getId() == 0 && InventoryBar.getActiveSlot() == 1){
			world.setTile(x, y, 2);
		}
		else if (world.getEntity(x, y).getId() == 0 && InventoryBar.getActiveSlot() == 2){
			world.setEntity(x, y, 1);
			System.out.println("hue");
		}
		else{
			((PassiveEntity) world.getEntity(x, y)).action(world, x, y);
		}
	}


}
