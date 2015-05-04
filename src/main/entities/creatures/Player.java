package main.entities.creatures;

import graphics.Assets;

import java.awt.Graphics;

import main.Game;
import main.KeyManager;
import main.tiles.Tile;
import main.worlds.World;

public class Player extends Creature{

	private float centerX, centerY;
	
	private int xWindowRange = 15; // the number of tiles that you can go in the x direction before the camera starts moving after you
	private int yWindowRange = 7; // the same number as above pretty much, but for y instead of x

	public Player(Game game, World world, float x, float y) {
		super(game, world, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, 0);
		// the player has the Entity id of 0
	
		game.getGameCamera().centerOnEntity(this);
		centerY = y * Tile.TILE_HEIGHT;
		centerX = x * Tile.TILE_WIDTH;
	}

	@Override
	public void tick() {
		
		getInput();
		
		if (x - centerX > (xWindowRange * Tile.TILE_WIDTH)){
			game.getGameCamera().move(Tile.TILE_WIDTH, 0);
			centerX += Tile.TILE_WIDTH;
		}
	
		if (x - centerX < (-xWindowRange * Tile.TILE_WIDTH)){
			game.getGameCamera().move(-Tile.TILE_WIDTH, 0);
			centerX -= Tile.TILE_WIDTH;
		}
		
		if (y - centerY > (yWindowRange * Tile.TILE_HEIGHT)){
			game.getGameCamera().move(0, Tile.TILE_HEIGHT);
			centerY += Tile.TILE_HEIGHT;
		}
		
		if (y - centerY < (-yWindowRange * Tile.TILE_HEIGHT)){
			game.getGameCamera().move(0, -Tile.TILE_HEIGHT);
			centerY -= Tile.TILE_HEIGHT;
		}
	}
	
	public void action(World world, int x, int y){
		
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
		
		if (game.getKeyManager().space){
			if (KeyManager.keyActive){
				getCurrentTile().action(world, (int)(x / Tile.TILE_WIDTH), (int)(y / Tile.TILE_HEIGHT));
			}
			KeyManager.keyActive = false;
		}
	}

	public void render(Graphics g) {
		
		g.drawImage(Assets.player, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
		
	}
	
	

}
