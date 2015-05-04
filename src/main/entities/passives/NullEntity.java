package main.entities.passives;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import main.worlds.World;

public class NullEntity extends PassiveEntity{
	


	private BufferedImage texture;

	/*
	public FenceEntity(Game game, World world, float x, float y, int width, int height, BufferedImage texture) {
		super(game, world, x, y, width, height);
		this.texture = Assets.woodWall;
	}
	*/
	
	public NullEntity(int id){
		super(Assets.nullAsset, id);
	}
	
	public void action(World world, int x, int y){
		world.setEntity(x, y, 1);
	}



}
