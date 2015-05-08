package main.states;

import graphics.Assets;
import graphics.hud.HUD;
import graphics.hud.InventoryBar;

import java.awt.Graphics;
import java.util.LinkedList;

import main.Game;
import main.entities.creatures.Player;
import main.worlds.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	private HUD invBar;
	
	public GameState(Game game){
		super(game);
		
		world = new World(game, "res/worlds/world1.txt");
		player = new Player(game, world, world.getWidth() / 2, world.getHeight() / 2);
		invBar = new InventoryBar(Assets.inventoryBar, 4);

	
	}

	@Override
	public void tick() {
		world.tick();
		player.tick();
		
	}

	@Override
	public void render(Graphics g) {
		
		world.render(g);
		player.render(g);
		invBar.render(g, game.getWidth() / 2 - invBar.getWidth() / 2, game.getHeight() - invBar.getHeight(), 320, 32);
	
	}
	
	// this is for testing purposes
	/*
	public static void main(String [] args){
		LinkedList hue = new LinkedList();
		LinkedList hue_too = new LinkedList();
		
		hue_too.offer(1);
		
		hue.offer(hue_too);
		hue.offer(hue_too);
		System.out.println(hue);

	}
	*/
	
	

}
