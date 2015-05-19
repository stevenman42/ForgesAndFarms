package main.entities.passives;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import graphics.Assets;
import main.Game;
import main.tiles.Tile;
import main.worlds.World;

public class WireEntity extends PassiveEntity{
	
	int aboveWire = 0;
	int belowWire = 0;
	int wire = 0, rightWire = 0, leftWire = 0;
	
	
	BufferedImage wireLine, wireDot, wireIntersection, wireTIntersection, wireCorner;
	
	// Rotation information

	//double rotationRequired = Math.toRadians(90);
	double locationX = Assets.wireLine.getWidth() / 2;
	double locationY = Assets.wireLine.getHeight() / 2;
	AffineTransform transform90 = AffineTransform.getRotateInstance(Math.toRadians(90), locationX, locationY);
	AffineTransformOp op90 = new AffineTransformOp(transform90, AffineTransformOp.TYPE_BILINEAR);
	
	AffineTransform transformNeg90 = AffineTransform.getRotateInstance(Math.toRadians(-90), locationX, locationY);
	AffineTransformOp opNeg90 = new AffineTransformOp(transformNeg90, AffineTransformOp.TYPE_BILINEAR);
	
	AffineTransform transform180 = AffineTransform.getRotateInstance(Math.toRadians(180), locationX, locationY);
	AffineTransformOp op180 = new AffineTransformOp(transform180, AffineTransformOp.TYPE_BILINEAR);

	public WireEntity(int id) {
		super(Assets.wireDot, id);
		System.out.println("WireEntity constructor");
	}
	
	public static void updateWire(){
		for (int i = 1; i < World.getWidth() - 1; i ++){
			for (int j = 1; j < World.getHeight() - 1; j ++){
				unpowerWire(i, j);
			}
		}
	}
	
	public static void unpowerWire(int x, int y){
		if (World.getEntity(x, y).getId() == 6)
			World.setEntity(x, y, 5);
		if (World.getEntity(x + 1, y).getId() == 6){
			World.setEntity(x + 1, y, 5);
			unpowerWire(x + 1, y);
		}
		if (World.getEntity(x - 1, y).getId() == 6){
			World.setEntity(x - 1, y, 5);
			unpowerWire(x - 1, y);
		}
		if (World.getEntity(x, y + 1).getId() == 6){
			World.setEntity(x, y + 1, 5);
			unpowerWire(x, y + 1);
		}
		if (World.getEntity(x, y - 1).getId() == 6){
			World.setEntity(x, y - 1, 5);
			unpowerWire(x, y - 1);
		}
		
	}

	@Override
	public boolean action(World world, int x, int y, int code) {
		World.setEntity(x, y, 0);
		updateWire();
		return false;
	}
	
	public boolean isActive(){
		if (id == 6)
			return true;
		else
			return false;
	}
	
	@Override
	public void render(Graphics g, int x, int y){
		
		boolean red = false;
		
		//updateWire();
		
		//System.out.println(poweredBlockIsInChain((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT));
		
		//System.out.println("WireEntity render method");
		try{
			red = (World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT - 1).isActive())
					|| (World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT + 1).isActive())
					|| (World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH + 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).isActive() &&
							World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH + 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).getId() != 9)
					|| (World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH - 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).isActive());
		}catch(IndexOutOfBoundsException e){
			red = true;
		}
		if (red){
			wireLine = Assets.redWireLine;
			wireDot = Assets.redWireDot;
			wireIntersection = Assets.redWireIntersection;
			wireTIntersection = Assets.redWireTIntersection;
			wireCorner = Assets.redWireCorner;
			World.setEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT, 6);
		}
		else{

			wireLine = Assets.wireLine;
			wireDot = Assets.wireDot;
			wireIntersection = Assets.wireIntersection;
			wireTIntersection = Assets.wireTIntersection;
			wireCorner = Assets.wireCorner;
			World.setEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT, 5);

		}
			
		
		try{
			
			aboveWire = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT - 1).getId();
			belowWire = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT + 1).getId();
			wire = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).getId();
			leftWire = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH - 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).getId();
			rightWire = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH + 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).getId();

			//System.out.println(wire + " " + aboveWire + " " + belowWire + " " + leftWire + " " + rightWire);
		}catch(IndexOutOfBoundsException e){
			System.out.println("StoneFenceEntity.java: ");
		}
		try{
			
			aboveWire = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT - 1).getId();
			belowWire = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT + 1).getId();
			wire = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).getId();
			leftWire = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH - 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).getId();
			rightWire = World.getEntity((int)(x + Game.getGameCamera().getxOffset()) / Tile.TILE_WIDTH + 1, (int)(y + Game.getGameCamera().getyOffset()) / Tile.TILE_HEIGHT).getId();

			
		}catch(IndexOutOfBoundsException e){
			//System.out.println("StoneFenceEntity.java: ");
		}
		//System.out.println("mi");
		if (((aboveWire == wire || belowWire == wire) && (wire == 5 || wire == 6)) && leftWire != wire && rightWire != wire){
			g.drawImage(op90.filter(wireLine, null), x, y, null);
		}
		else if ((rightWire == wire && belowWire == wire && leftWire == wire && (wire == 5 || wire == 6))){
			g.drawImage(wireTIntersection, x, y, null);
		}
		else if (rightWire == wire && leftWire == wire && aboveWire == wire && (wire == 5 || wire == 6)){
			g.drawImage(op180.filter(wireTIntersection, null), x, y, null);
		}
		
		else if (rightWire == wire && aboveWire == wire && belowWire == wire && (wire == 5 || wire == 6)){
			g.drawImage(opNeg90.filter(wireTIntersection, null), x, y, null);
		}
		
		else if (leftWire == wire && aboveWire == wire && belowWire == wire && (wire == 5 || wire == 6)){
			g.drawImage(op90.filter(wireTIntersection, null), x, y, null);
		}
		
		else if ((leftWire == wire && belowWire == wire) && (wire == 5 || wire == 6)){
			g.drawImage(wireCorner, x, y, null);
		}
		else if ((rightWire == wire && belowWire == wire) && (wire == 5 || wire == 6)){
			g.drawImage(opNeg90.filter(wireCorner, null), x, y, null);
		}
		else if ((leftWire == wire && aboveWire == wire) && (wire == 5 || wire == 6)){
			g.drawImage(op90.filter(wireCorner,null), x, y, null);
		}
		else if ((rightWire == wire && aboveWire == wire) && (wire == 5 || wire == 6)){
			g.drawImage(op180.filter(wireCorner, null), x, y, null);
		}
		

		
		else
			g.drawImage(wireLine, x, y, 16, 16, null);
		
		
		if (aboveWire == wire && leftWire == wire && rightWire == wire && belowWire == wire && (wire == 5 || wire == 6)){
			g.drawImage(wireIntersection, x, y, null);
		}
	}

}
