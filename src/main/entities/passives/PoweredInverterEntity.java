package main.entities.passives;

import java.awt.Graphics;

import graphics.Assets;
import main.Game;
import main.tiles.Tile;
import main.worlds.World;

public class PoweredInverterEntity extends PassiveEntity{

	public PoweredInverterEntity(int id) {
		super(Assets.inverter, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean action(World world, int x, int y, int code) {
		
		World.setEntity(x, y, 0);
		
		return false;
	}

	
	public boolean isActive(){
		return false;
	}
	
	public void render(Graphics g, int x, int y){
		if (!(World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH - 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).isActive())){
			World.setEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT, 9);
			WireEntity.updateWire();
			System.out.println("agh");
		}
		g.drawImage(Assets.inverter, x, y, null);
	}

	
}
