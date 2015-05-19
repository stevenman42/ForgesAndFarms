package main.entities.passives;

import graphics.Assets;
import main.worlds.World;

public class InverterEntity extends PassiveEntity{
	
	public boolean powered = false;

	public InverterEntity(int id) {
		super(Assets.inverter, id);
	}

	@Override
	public boolean action(World world, int x, int y, int code) {
		// TODO Auto-generated method stub
		return false;
	}

}
