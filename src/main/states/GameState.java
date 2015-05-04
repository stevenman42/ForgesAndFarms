package main.states;

import graphics.Assets;
import graphics.hud.HUD;
import graphics.hud.InventoryBar;

import java.awt.Graphics;

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
		//invBar.render(g, game.getWidth() / 2 - 80, game.getHeight() - 16 );
	
	}
	
	

}
