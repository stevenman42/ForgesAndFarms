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
	


	
	int entityAbove = 0;
	int entityBelow = 0;
	int entity = 0;
	
	// Rotation information

	double rotationRequired = Math.toRadians(90);
	double locationX = Assets.stoneWall.getWidth() / 2;
	double locationY = Assets.stoneWall.getHeight() / 2;
	AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
	AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

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
			
			entityAbove = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT - 1).getId();
			entityBelow = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT + 1).getId();
			entity = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).getId();

		}catch(IndexOutOfBoundsException e){
			//System.out.println("StoneFenceEntity.java: ");
		}
		if ((entityAbove == entity || entityBelow == entity) && entity == 1){
			g.drawImage(op.filter(Assets.woodWall, null), x, y, null);
		}
		else
			g.drawImage(Assets.woodWall, x, y, 16, 16, null);
		

	}



}
