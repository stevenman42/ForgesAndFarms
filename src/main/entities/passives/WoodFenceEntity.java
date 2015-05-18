package main.entities.passives;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import main.Game;
import main.tiles.Tile;
import main.worlds.World;

public class WoodFenceEntity extends PassiveEntity{
	


	
	int aboveEntity = 0;
	int belowEntity = 0;
	int entity = 0, rightEntity = 0, leftEntity = 0;


	// Rotation information

	double rotationRequired = Math.toRadians(90);
	double locationX = Assets.stoneWall.getWidth() / 2;
	double locationY = Assets.stoneWall.getHeight() / 2;
	AffineTransform transform90 = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
	AffineTransformOp op90 = new AffineTransformOp(transform90, AffineTransformOp.TYPE_BILINEAR);
	
	AffineTransform transformNeg90 = AffineTransform.getRotateInstance(Math.toRadians(-90), locationX, locationY);
	AffineTransformOp opNeg90 = new AffineTransformOp(transformNeg90, AffineTransformOp.TYPE_BILINEAR);
	
	AffineTransform transform180 = AffineTransform.getRotateInstance(Math.toRadians(180), locationX, locationY);
	AffineTransformOp op180 = new AffineTransformOp(transform180, AffineTransformOp.TYPE_BILINEAR);
	

	private BufferedImage texture;
	
	public String name = "wood_fence"; // this should be temporary

	/*
	public FenceEntity(Game game, World world, float x, float y, int width, int height, BufferedImage texture) {
		super(game, world, x, y, width, height);
		this.texture = Assets.woodWall;
	}
	*/
	
	public WoodFenceEntity(int id){
		super(Assets.woodWall, id);
	}
	
	public void action(World world, int x, int y){
		world.setEntity(x, y, 0);
	}

	@Override
	public void render(Graphics g, int x, int y){
		
		try{
			
			aboveEntity = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT - 1).getId();
			belowEntity = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT + 1).getId();
			entity = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).getId();
			leftEntity = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH - 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).getId();
			rightEntity = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH + 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).getId();

		}catch(IndexOutOfBoundsException e){
			//System.out.println("StoneFenceEntity.java: ");
		}
		if (((aboveEntity == entity || belowEntity == entity) && entity == 1) && leftEntity != entity && rightEntity != entity){
			g.drawImage(op90.filter(Assets.woodWall, null), x, y, null);
		}
		else if ((leftEntity == entity && belowEntity == entity) && entity == 1){
			g.drawImage(Assets.cornerWoodWall, x, y, null);
		}
		else if ((rightEntity == entity && belowEntity == entity) && entity == 1){
			g.drawImage(opNeg90.filter(Assets.cornerWoodWall, null), x, y, null);
		}
		else if ((leftEntity == entity && aboveEntity == entity) && entity == 1){
			g.drawImage(op90.filter(Assets.cornerWoodWall,null), x, y, null);
		}
		else if ((rightEntity == entity && aboveEntity == entity) && entity == 1){
			g.drawImage(op180.filter(Assets.cornerWoodWall, null), x, y, null);
		}
		else
			g.drawImage(Assets.woodWall, x, y, 16, 16, null);
		
		
		if (aboveEntity == entity && leftEntity == entity && rightEntity == entity && belowEntity == entity && entity == 1){
			g.drawImage(Assets.intersectionWoodWall, x, y, null);
		}
		


	}



}
