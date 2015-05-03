package main.worlds;

import java.awt.Graphics;
import java.util.Arrays;

import main.Game;
import main.tiles.Tile;
import main.utils.Utils;

public class World {
	
	private Game game;
	private int width, height; // in tiles
	private int spawnX, spawnY;
	private int[][] tiles;
	
	public World(Game game, String path){
		this.game = game;
		System.out.println("wat");
		//loadWorldFromFile(path);
		tiles = createWorld(200, 200);
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
			}
		}
		
	}
	
	public Tile getTile(int x, int y){
		Tile t = Tile.tiles[tiles[y][x]];
		if (t == null)
			return Tile.dirtTile;
		return t;
		
	}
	
	public void setTile(int x, int y, int id){
		System.out.println("before: " + tiles[x][y]);
		tiles[x][y] = id;
		System.out.println("after: " + tiles[x][y]);
		//for (int i = 0; i < tiles.length; i ++){
		//	System.out.println(Arrays.toString(tiles[i]));
		//}
	}
	
	
	
	private void loadWorldFromFile(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		
		for (int y = 0; y < height; y ++){
			for (int x = 0; x < width; x ++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	private int[][] createWorld(int worldWidth, int worldHeight){
		this.width = worldWidth;
		this.height = worldHeight;
		int[][] newWorld = new int[height][width];

		for (int i = 0; i < height; i ++){
			for (int j = 0; j < width; j ++){
				newWorld[i][j] = (int) (Math.random() * 2);
			}
		}
		return newWorld;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

}
