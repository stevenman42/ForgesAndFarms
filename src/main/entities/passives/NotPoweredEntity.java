package main.entities.passives;

import java.awt.Graphics;

import graphics.Assets;
import main.entities.Entity;
import main.inventory.Inventory;
import main.worlds.World;

public class NotPoweredEntity extends PassiveEntity{
	
	private boolean active;

	public NotPoweredEntity(int id) {
		super(Assets.notPoweredEntity, id);
	}

	@Override
	public boolean action(World world, int x, int y, int code) {
		if (Inventory.getActiveItem() == null || Inventory.getActiveItem().getClass() == Entity.entities[0].getClass()){
			World.setEntity(x, y, 0);
			WireEntity.unpowerWire(x, y);
			
			return false;
		}
		else if (Inventory.getActiveItem().getClass() == Entity.entities[7].getClass()){
			World.setEntity(x, y, 7);
			WireEntity.unpowerWire(x, y);

			return true;
		}
		return false;
	}
	
	public boolean isActive(){
		return false;
	}

}
