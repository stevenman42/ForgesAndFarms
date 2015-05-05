package graphics.hud;

import java.awt.image.BufferedImage;

public class InventoryBar extends HUD{
	
	private static int activeSlot = 1;
	private int width = 320;
	private int height = 32;


	public InventoryBar(BufferedImage texture, int id) {
		super(texture, id);
	}
	
	public static void setActiveSlot(int slot){
		activeSlot = slot;
	}
	
	public static int getActiveSlot(){
		return activeSlot;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

}
