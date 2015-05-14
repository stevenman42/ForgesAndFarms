package main.entities.creatures;

import java.awt.Graphics;

import graphics.Assets;
import main.Game;
import main.worlds.World;

public class Zombie extends Creature{

	private Player player;
	
	public Zombie(Game game, World world, Player player, float x, float y, int width,
			int height, int id) {
		super(game, world, x, y, width, height, id);
		this.player = player;
	}

	@Override
	public void tick() {
		if (player.getX() > x){
			move(16, 0);
		}
		else if (player.getX() < x){
			move(-16, 0);
		}
		if (player.getY() > y){
			move(0, 16);
		}
		else if (player.getY() < y){
			move(0, -16);
		}
		
	}
	
	public void render(Graphics g){
		g.drawImage(Assets.zombie, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
		System.out.println("( " + x + ", " + y + ")");
	}
	
	

}
