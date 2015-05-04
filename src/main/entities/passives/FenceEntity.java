package main.entities.passives;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import main.worlds.World;

public class FenceEntity extends PassiveEntity{
	
	private BufferedImage texture;

	/*
	public FenceEntity(Game game, World world, float x, float y, int width, int height, BufferedImage texture) {
		super(game, world, x, y, width, height);
		this.texture = Assets.woodWall;
	}
	*/
	
	public FenceEntity(int id){
		super(Assets.stoneWall, id);
	}
	

}
