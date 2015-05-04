package graphics.hud;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.entities.Entity;

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
	
	public void render(Graphics g, int x, int y){
		g.drawImage(Assets.inventoryBar, x, y, 160, 16, null);
	}


	
	

}
