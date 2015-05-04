package graphics.hud;

import java.awt.image.BufferedImage;

public class InventoryBar extends HUD{
	
	private static int activeSlot;

	public InventoryBar(BufferedImage texture, int id) {
		super(texture, id);
	}
	
	public static void setActiveSlot(int slot){
		activeSlot = slot;
	}
	
	public static int getActiveSlot(){
		return activeSlot;
	}

}
