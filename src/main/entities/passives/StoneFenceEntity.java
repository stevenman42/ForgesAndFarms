package main.entities.passives;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import main.Game;
import main.inventory.Inventory;
import main.tiles.Tile;
import main.worlds.World;

public class StoneFenceEntity extends PassiveEntity{
	


	private BufferedImage texture;
	
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
	
	// Drawing the rotated image at the required drawing locations
	

	/*
	public FenceEntity(Game game, World world, float x, float y, int width, int height, BufferedImage texture) {
		super(game, world, x, y, width, height);
		this.texture = Assets.woodWall;
	}
	*/
	
	public String name = "stone_fence"; // this should be  pretty temporary
	
	public StoneFenceEntity(int id){
		super(Assets.stoneWall, id);
	}
	
	public void action(World world, int x, int y){
		if (Inventory.getActiveItem() == null){
			System.out.println("main.entities.passives.StoneFenceEntity.java: ye");
		}
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
		if (((aboveEntity == entity || belowEntity == entity) && entity == 2) && leftEntity != entity && rightEntity != entity){
			g.drawImage(op90.filter(Assets.stoneWall, null), x, y, null);
		}
		else if ((rightEntity == entity && belowEntity == entity && leftEntity == entity && entity == 2)){
			g.drawImage(Assets.tIntersectionStoneWall, x, y, null);
		}
		else if (rightEntity == entity && leftEntity == entity && aboveEntity == entity && entity == 2){
			g.drawImage(op180.filter(Assets.tIntersectionStoneWall, null), x, y, null);
		}
		
		else if (rightEntity == entity && aboveEntity == entity && belowEntity == entity && entity == 2){
			g.drawImage(opNeg90.filter(Assets.tIntersectionStoneWall, null), x, y, null);
		}
		
		else if (leftEntity == entity && aboveEntity == entity && belowEntity == entity && entity == 2){
			g.drawImage(op90.filter(Assets.tIntersectionStoneWall, null), x, y, null);
		}
		
		else if ((leftEntity == entity && belowEntity == entity) && entity == 2){
			g.drawImage(Assets.cornerStoneWall, x, y, null);
		}
		else if ((rightEntity == entity && belowEntity == entity) && entity == 2){
			g.drawImage(opNeg90.filter(Assets.cornerStoneWall, null), x, y, null);
		}
		else if ((leftEntity == entity && aboveEntity == entity) && entity == 2){
			g.drawImage(op90.filter(Assets.cornerStoneWall,null), x, y, null);
		}
		else if ((rightEntity == entity && aboveEntity == entity) && entity == 2){
			g.drawImage(op180.filter(Assets.cornerStoneWall, null), x, y, null);
		}
		

		
		else
			g.drawImage(Assets.stoneWall, x, y, 16, 16, null);
		
		
		if (aboveEntity == entity && leftEntity == entity && rightEntity == entity && belowEntity == entity && entity == 2){
			g.drawImage(Assets.intersectionStoneWall, x, y, null);
		}
		


	}


}
