package main.states;

import graphics.Assets;

import java.awt.Graphics;

import main.Game;
import main.entities.creatures.Player;
import main.entities.passives.PassiveEntity;
import main.worlds.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	
	public GameState(Game game){
		super(game);
		
		world = new World(game, "res/worlds/world1.txt");
		player = new Player(game, world, world.getWidth() / 2, world.getHeight() / 2);

	
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
	
	}
	
	

}
