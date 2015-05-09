package main.inventory;

import graphics.hud.InventoryBar;

public class Inventory {
	
	private static Object[] hotbar = new Object[10];
	
	public static Object getItem(int slot){
		return hotbar[slot];
	}
	
	public static Object getActiveItem(){
		return hotbar[InventoryBar.getActiveSlot()];
	}
	
	public static void changeItem(Object newItem, int oldSlot, int newSlot){
		Object temp = hotbar[oldSlot];
		
		hotbar[oldSlot] = hotbar[newSlot];
		hotbar[newSlot] = temp;
	}
	
	public static boolean changeItem(Object newItem){
		
		for (int i = 0; i < 10; i ++){
			if (hotbar[i] == null){
				hotbar[i] = newItem;
				return true;
			}
		}
		
		System.out.println("Could not add item because there are no empty slots");
		return false;
	}
}
