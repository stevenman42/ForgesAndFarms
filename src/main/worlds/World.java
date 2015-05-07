package main.worlds;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.Game;
import main.entities.Entity;
import main.tiles.Tile;
import main.utils.Utils;

public class World {
	
	private Game game;
	private int width, height; // in tiles
	private int spawnX, spawnY;
	//private int[][] tiles;
	List<List<Integer>> tiles;
	private List<List<Integer>> entities;
	
	public World(Game game, String path){
		this.game = game;
		//loadWorldFromFile(path);
		tiles = createWorld(20, 21);
		entities = randomEntities(tiles.size(), tiles.get(0).size());

	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, game.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (game.getGameCamera().getxOffset() + game.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, game.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (game.getGameCamera().getyOffset() + game.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for (int y = yStart; y < yEnd; y ++){
			for (int x = xStart; x < xEnd; x ++){
				//System.out.println(x + " " + y);
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
				if (getEntity(x, y) != null){
					getEntity(x, y).render(g, (int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
				}
			}
		}
		
	}
	
	public Entity getEntity(int x, int y){
		//Entity e = Entity.entities[entities[y][x]];
		Entity e = Entity.entities[this.entities.get(y).get(x)];
		return e;
	}
	
	public Tile getTile(int x, int y){
		try{
			Tile t = Tile.tiles[tiles.get(y).get(x)];
			if (t == null)
				return Tile.dirtTile;
			return t;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("nope");
			return Tile.dirtTile;
		}
	}
	
	public void setTile(int x, int y, int id){
		tiles.get(y).set(x, id);
	}
	
	public void setEntity(int x, int y, int id){
		entities.get(y).set(x, id);
	}
	
	
	
	private void loadWorldFromFile(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		//tiles = new int[width][height];
		tiles = new ArrayList<List<Integer>>();
		
		for (int y = 0; y < height; y ++){
			for (int x = 0; x < width; x ++){
				tiles.get(x).set(y, Utils.parseInt(tokens[(x + y * width) + 4]));
			}
		}
	}
	
	private List<List<Integer>> createWorld(int worldWidth, int worldHeight){
		this.width = worldWidth;
		this.height = worldHeight;
		List<List<Integer>> newWorld = new ArrayList<List<Integer>>();
		
		// Fills the world with 0s
		List<Integer> row = new ArrayList<Integer>();
		for (int j = 0; j < worldWidth; j ++){
			row.add(0);
		}
		for (int i = 0; i < worldHeight; i ++){
			newWorld.add(row);
		}

		for (int i = 0; i < height; i ++){
			for (int j = 0; j < width; j ++){
				//newWorld.get(i).get(j) = (int) (Math.random() * 2);
				newWorld.get(i).set(j, (int) (Math.random() * 2));
			}
		}

		System.out.println(newWorld);
		
		return newWorld;
		
		
	}
	
	// this should be a pretty temporary thing
	private List<List<Integer>> randomEntities(int height, int width){
		List<List<Integer>> entities = new ArrayList<List<Integer>>();
		
		List<Integer> row = new ArrayList<Integer>();
		
		for (int j = 0; j < width; j ++){
			row.add(0);
		}
		
		for (int i = 0; i < height; i ++){
			
			entities.add(row);
		
		}
		
		return entities;

	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

}
