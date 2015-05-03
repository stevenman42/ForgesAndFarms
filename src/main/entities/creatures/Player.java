package main.entities.creatures;

import graphics.Assets;

import java.awt.Graphics;

import main.Game;
import main.KeyManager;

public class Player extends Creature{


	public Player(Game game, float x, float y) {
		super(game, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

	@Override
	public void tick() {
		
		getInput();
		//move();
		game.getGameCamera().centerOnEntity(this);
		
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if (game.getKeyManager().up){
			if (KeyManager.keyActive){move(0, -speed);}
			KeyManager.keyActive = false;
		}
		if (game.getKeyManager().down){
			if (KeyManager.keyActive){move(0, speed);}
			KeyManager.keyActive = false;
		}
		if (game.getKeyManager().left){
			if (KeyManager.keyActive){move(-speed, 0);}
			KeyManager.keyActive = false;
		}
		if (game.getKeyManager().right){
			if (KeyManager.keyActive){move(speed, 0);}
			KeyManager.keyActive = false;
		}
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.player, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
		
	}
	
	

}
