package main.entities.creatures;

import java.awt.Graphics;

import graphics.Assets;
import main.Game;
import main.worlds.World;

public class Zombie extends Creature{

	private Player player;
	private static boolean moved = false;
	
	public Zombie(Game game, World world, Player player, float x, float y, int width,
			int height, int id) {
		super(game, world, x, y, width, height, id);
		this.player = player;
	}

	@Override
	public void tick() {
		if (player.getX() > x){
			if (!moved){
				move(16, 0);
				moved = true;
			}
		}
		else if (player.getX() < x){
			if (!moved){
				move(-16, 0);
				moved = true;
			}
		}
		if (player.getY() > y){
			if (!moved){
				move(0, 16);
				moved = true;
			}
		}
		else if (player.getY() < y){
			if (!moved){
				move(0, -16);
				moved = true;
			}
		}
		
		
	}
	
	public static void setMoved(boolean newMove){
		moved = newMove;
	}
	
	public void render(Graphics g){
		g.drawImage(Assets.zombie, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
	}
}
