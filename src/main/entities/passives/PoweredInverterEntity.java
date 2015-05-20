package main.entities.passives;

import java.awt.Graphics;

import graphics.Assets;
import main.Game;
import main.tiles.Tile;
import main.worlds.World;

public class PoweredInverterEntity extends PassiveEntity{
	
	private static boolean toggled;

	public PoweredInverterEntity(int id) {
		super(Assets.poweredInverter, id);
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
		

		if ((World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH - 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).isActive())){
			//World.setEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT, 10);
			//WireEntity.updateWire();
		}
		else{
			
			
			World.setEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT, 9);
			//World.setEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH - 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT, 6);
			//WireEntity.updateWire();
			//System.out.println("hur");
		}
		//System.out.println((World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH - 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).isActive()));
		
		g.drawImage(Assets.poweredInverter, x, y, null);
	}

	public static void setToggled(boolean newT){
		toggled = newT;
	}
	
}
