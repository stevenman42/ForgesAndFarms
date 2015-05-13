package main.tiles;

import graphics.Assets;
import graphics.hud.InventoryBar;
import main.entities.Entity;
import main.entities.passives.PassiveEntity;
import main.inventory.Inventory;
import main.worlds.World;

public class DirtTile extends Tile{
	
	public DirtTile(int id){
		super(Assets.dirt, id);
	}
	
	public void action(World world, int x, int y){
		if (Inventory.getActiveItem() != null && Inventory.getActiveItem().getClass() != Entity.entities[0].getClass() &&
				(world.getEntity(x, y).getClass() == Entity.entities[0].getClass() || world.getEntity(x, y) == null)){
			world.setEntity(x, y, ((Entity) Inventory.getActiveItem()).getId());
		}
		else if (world.getEntity(x, y).getId() == 0 || world.getEntity(x, y) == null){
			world.setTile(x, y, 2);
		}
		else{
			((PassiveEntity) world.getEntity(x, y)).action(world, x, y);
		}
	}
	
	public Tiles getId(){
		return Tiles.dirt;
	}


}
