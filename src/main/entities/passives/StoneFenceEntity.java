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
	
	private boolean rendered;


	// Rotation information

	double rotationRequired = Math.toRadians(90);
	double locationX = Assets.stoneWall.getWidth() / 2;
	double locationY = Assets.stoneWall.getHeight() / 2;
	AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
	AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

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

			if (x >= 1 && x < World.getWidth() * Tile.TILE_WIDTH - Tile.TILE_WIDTH && y >= 1 && y < World.getWidth() * Tile.TILE_HEIGHT - Tile.TILE_HEIGHT){
				if (World.getEntity(x / Tile.TILE_WIDTH, y / Tile.TILE_HEIGHT - 1) != null && World.getEntity(x / Tile.TILE_WIDTH, y / Tile.TILE_HEIGHT - 1).getId() == 2
						|| World.getEntity(x / Tile.TILE_WIDTH, y / Tile.TILE_HEIGHT + 1) != null && World.getEntity(x / Tile.TILE_WIDTH, y / Tile.TILE_HEIGHT + 1).getId() == 2){
					System.out.println("I'm rotating the entity at (" + x / Tile.TILE_WIDTH + ", " + y / Tile.TILE_HEIGHT + ") " + "because the entity at (" + x / Tile.TILE_WIDTH + ", " + (y / Tile.TILE_HEIGHT + 1) + ") or (" + x / Tile.TILE_WIDTH + " ," + (y / Tile.TILE_HEIGHT - 1) + ") is a fence.");
					g.drawImage(op.filter(Assets.stoneWall, null), x, y, null);
					//g.drawRoundRect(x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, 3, 3);
					// test
					rendered = true;
				}
			else
				if (id != 0);
					
			}
			if (!rendered){
				g.drawImage(Assets.stoneWall, x, y, 16, 16, null);
				rendered = true;
			}
			rendered = false;
		}catch(IndexOutOfBoundsException e){
			System.out.println("StoneFenceEntity.java: ");
		}
	}


}
