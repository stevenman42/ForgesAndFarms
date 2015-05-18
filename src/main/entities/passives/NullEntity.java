package main.entities.passives;

import graphics.Assets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import main.worlds.World;

public class NullEntity extends PassiveEntity{
	


	private BufferedImage texture;

	
	public NullEntity(int id){
		super(Assets.nullAsset, id);
	}
	
	public boolean action(World world, int x, int y, int code){
		return false;
	}





}
