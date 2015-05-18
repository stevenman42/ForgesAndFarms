package main.entities;

import graphics.Assets;

import java.awt.image.BufferedImage;

import main.worlds.World;

public class WoodBoxEntity extends Entity {

	public WoodBoxEntity(int id) {
		super(Assets.woodenBox, id);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}
	

	
	
	public boolean isSolid(){
		return true;
	}

	@Override
	public boolean action(World world, int x, int y, int code) {
		
		if (code == 1)
			return move(x, y, 0, 1);
		else if (code == -1)
			return move(x, y, 0, -1);
		else if (code == 2)
			return move(x, y, 1, 0);
		else if (code == -2)
			return move(x, y, -1, 0);
		
		return false;
		
	}

	public boolean isPushable(){
		return true;
	}

}
