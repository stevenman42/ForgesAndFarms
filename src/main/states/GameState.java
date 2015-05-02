package main.states;

import graphics.Assets;

import java.awt.Graphics;

import main.Game;
import main.entities.creatures.Player;

public class GameState extends State{
	
	private Player player;
	
	public GameState(Game game){
		super(game);
		player = new Player(game, 128, 128);
		
	}

	@Override
	public void tick() {
		player.tick();
		
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.grass, 0, 0, null);
		player.render(g);
		
	}
	
	

}
