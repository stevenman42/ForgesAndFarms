package main.inventory;

import graphics.hud.InventoryBar;

public class Inventory {
	
	private static Object[] hotbar = new Object[10];
	
	// returns the object a particular slot in the hotbar
	public static Object getItem(int slot){
		return hotbar[slot];
	}
	
	// returns the "active" object in the inventory - the one that the box is on
	public static Object getActiveItem(){
		return hotbar[InventoryBar.getActiveSlot() - 1];
	}
	
	// modifies the  hotbar by switching two items
	public static void changeItem(Object newItem, int oldSlot, int newSlot){
		Object temp = hotbar[oldSlot];
		
		hotbar[oldSlot] = hotbar[newSlot];
		hotbar[newSlot] = temp;
		
	}
	
	// modifies the hotbar by putting a new item in the first empty slot an empty slot
	public static boolean changeItem(Object newItem){
		
		for (int i = 0; i < 10; i ++){
			
			// returns false if the item already is in the inventory
			if (hotbar[i] != null && (hotbar[i] == newItem || hotbar[i].getClass() == newItem.getClass())){
				System.out.println("you already have that in your inventory");
				return false;
			}
			

			else if (hotbar[i] == null){
				hotbar[i] = newItem;
				return true;
			}
		}
		
		for (int i = 0; i < 10; i ++){
			System.out.println(hotbar[i].getClass());
		}
		
		System.out.println("Could not add item because there are no empty slots");
		return false;
	}
}
