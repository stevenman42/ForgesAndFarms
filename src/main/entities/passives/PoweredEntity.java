package main.entities.passives;

import java.awt.Graphics;

import graphics.Assets;
import main.Game;
import main.entities.Entity;
import main.inventory.Inventory;
import main.tiles.Tile;
import main.worlds.World;

public class PoweredEntity extends PassiveEntity{
	
	public PoweredEntity(int id) {
		super(Assets.poweredEntity, id);
	}

	@Override
	public boolean action(World world, int x, int y, int code) {
		if (Inventory.getActiveItem() == null || Inventory.getActiveItem().getClass() == Entity.entities[0].getClass()){
			World.setEntity(x, y, 0);
			WireEntity.unpowerWire(x, y);
			WireEntity.updateWire();
			return false;
		}
		else if (Inventory.getActiveItem().getClass() == Entity.entities[7].getClass()){
			World.setEntity(x, y, 8);
			WireEntity.unpowerWire(x, y);
			WireEntity.updateWire();
			return true;
		}
		return false;
	}
	

	
	public boolean isActive(){
		return true;
	}

}
