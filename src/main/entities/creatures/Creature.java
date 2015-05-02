package main.entities.creatures;

import java.awt.Graphics;

import main.entities.Entity;

public abstract class Creature extends Entity{
	
	protected int health;

	public Creature(float x, float y) {
		super(x, y);
		health = 10;
	}
	

}
