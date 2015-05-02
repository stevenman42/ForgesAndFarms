package graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 16, height = 16;
	
	public static BufferedImage grass, dirt, stone, tilledDirt, // tiles
								woodWall, stoneWall,
								player;
	
	
	// loads in everything for the game
	// should only be called once
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite_sheet.png"));
		
		grass = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(16, 0, width, height);
		stone = sheet.crop(32, 0, width, height);
		tilledDirt = sheet.crop(48, 0, width, height);
		
		woodWall = sheet.crop(0, 16, width, height);
		stoneWall = sheet.crop(16, 16, width, height);
		
		player = sheet.crop(0, 48, width, height);
		
	}

}
