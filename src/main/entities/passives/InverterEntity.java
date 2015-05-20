package main.entities.passives;

import java.awt.Graphics;

import graphics.Assets;
import main.Game;
import main.tiles.Tile;
import main.worlds.World;

public class InverterEntity extends PassiveEntity{
	
	public static boolean toggled;

	public InverterEntity(int id) {
		super(Assets.unpoweredInverter, id);
	}

	@Override
	public boolean action(World world, int x, int y, int code) {
		
		World.setEntity(x, y, 0);
		toggled = false;
		
		return false;
	}
	
	public boolean isActive(){
		return true;
	}
	

	
	public void render(Graphics g, int x, int y){
		

		if ((World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH - 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).isActive())){
			World.setEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT, 10);
			//WireEntity.updateWire();
		}
		else{
			World.setEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT, 9);
			//World.setEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH - 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT, 6);
			//System.out.println("other hur");
			//WireEntity.updateWire();
			
		}
		
		g.drawImage(Assets.unpoweredInverter, x, y, null);
	}

}
