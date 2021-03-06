package graphics.hud;

import graphics.Assets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.entities.Entity;
import main.inventory.Inventory;
import main.tiles.Tile;
import main.worlds.World;

public class HUD extends Entity{

	protected BufferedImage texture;
	private int width, height;
	protected float x, y;
	

	public HUD(BufferedImage texture, int id) {
		super(texture, id);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
	public void render(Graphics g, int x, int y, int width, int height){
		g.drawImage(Assets.inventoryBar, x, y, width, height, null);
		g.setColor(Color.red);
		g.drawRect(x + 32 * (InventoryBar.getActiveSlot() - 1), y, 32, 32);
		for (int i = 0; i < 10; i ++){
			try{
				Tile stupid = (Tile) Inventory.getItem(i);
				if (stupid != null){
					g.drawImage(stupid.getTexture(), x + 32 * i + 8, y + 8, null);
					//stupid.render(g, x + 32 * i + 8, y + 8);
				}
			}catch(ClassCastException e){
				Entity notStupid = (Entity) Inventory.getItem(i);
				if (notStupid != null)
					g.drawImage(notStupid.getTexture(), x + 32 * i + 8, y + 8, null);
			}
		}
	}



	@Override
	public boolean action(World world, int x, int y, int code) {
		return false;
		
	}


	
	

}
