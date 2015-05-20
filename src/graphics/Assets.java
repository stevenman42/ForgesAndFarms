package graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 16, height = 16;
	
	public static BufferedImage grass, dirt, stone, tilledDirt, // tiles
								woodenBox,
								woodWall, stoneWall, cornerWoodWall, cornerStoneWall, intersectionWoodWall, intersectionStoneWall, tIntersectionWoodWall, tIntersectionStoneWall,
								wireDot, wireLine, wireIntersection, wireTIntersection, wireCorner, redWireDot, redWireLine, redWireIntersection, redWireTIntersection, redWireCorner, poweredEntity, notPoweredEntity, poweredInverter, unpoweredInverter,
								player, zombie,
								inventoryBar,
								nullAsset;
	
	
	// loads in everything for the game
	// should only be called once
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite_sheet.png"));
		
		grass = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(16, 0, width, height);
		stone = sheet.crop(32, 0, width, height);
		tilledDirt = sheet.crop(48, 0, width, height);
		
		woodenBox = sheet.crop(128, 16, width, height);
		
		woodWall = sheet.crop(0, 16, width, height);
		stoneWall = sheet.crop(16, 16, width, height);
		cornerWoodWall = sheet.crop(32, 16, width, height);
		cornerStoneWall = sheet.crop(48, 16, width, height);
		intersectionWoodWall = sheet.crop(64, 16, width, height);
		intersectionStoneWall = sheet.crop(80, 16, width, height);
		tIntersectionWoodWall = sheet.crop(96, 16, width, height);
		tIntersectionStoneWall = sheet.crop(112, 16, width, height);
		
		wireDot = sheet.crop(144, 16, width, height);
		wireLine = sheet.crop(112, 32, width, height);
		wireIntersection = sheet.crop(96, 32, width, height);
		wireTIntersection = sheet.crop(128, 32, width, height);
		wireCorner = sheet.crop(144, 32, width, height);

		redWireDot = sheet.crop(80, 32, width, height);
		redWireLine = sheet.crop(64, 48, width, height);
		redWireIntersection = sheet.crop(64, 32, width, height);
		redWireTIntersection = sheet.crop(80, 48, width, height);
		redWireCorner = sheet.crop(96, 48, width, height);
		
		poweredEntity = sheet.crop(48, 48, width, height);
		notPoweredEntity = sheet.crop(32, 48, width, height);
		poweredInverter = sheet.crop(112, 48, width, height);
		unpoweredInverter = sheet.crop(128, 48, width, height);
		
		
		player = sheet.crop(0, 48, width, height);
		zombie = sheet.crop(16, 48, width, height);
		
		nullAsset = sheet.crop(0, 0, 1, 1);
		
		SpriteSheet menus = new SpriteSheet(ImageLoader.loadImage("/textures/menu_textures.png"));
		inventoryBar = menus.crop(0, 0, 160, 16); 
		
	}

}
