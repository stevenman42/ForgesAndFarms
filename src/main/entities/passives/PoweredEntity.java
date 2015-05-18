package main.entities.passives;

import graphics.Assets;
import main.worlds.World;

public class PoweredEntity extends PassiveEntity{

	public PoweredEntity(int id) {
		super(Assets.poweredEntity, id);
	}

	@Override
	public boolean action(World world, int x, int y, int code) {
		World.setEntity(x, y, 0);
		return false;
	}
	
	public boolean isActive(){
		return true;
	}

}
