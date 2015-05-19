package main.entities.passives;

import graphics.Assets;
import main.worlds.World;

public class Inverter extends PassiveEntity{

	public Inverter(int id) {
		super(Assets.inverter, id);
	}

	@Override
	public boolean action(World world, int x, int y, int code) {
		// TODO Auto-generated method stub
		return false;
	}

}
