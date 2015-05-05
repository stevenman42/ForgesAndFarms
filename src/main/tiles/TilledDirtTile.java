package main.tiles;

import graphics.Assets;
import main.entities.passives.PassiveEntity;
import main.worlds.World;

public class TilledDirtTile extends Tile{
	
	public TilledDirtTile(int id){
		super(Assets.tilledDirt, id);
	}
	
	public void action(World world, int x, int y){
		if(world.getEntity(x, y).getId() == 0){
			world.setTile(x, y, 0);
		}
		else{
			((PassiveEntity) world.getEntity(x, y)).action(world, x, y);
		}
	}
	
	public Tiles getId(){
		return Tiles.tilledDirt;
	}

}
