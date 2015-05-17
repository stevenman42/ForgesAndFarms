package main.worlds;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import main.Game;
import main.entities.Entity;
import main.entities.passives.NullEntity;
import main.tiles.Tile;
import main.utils.Utils;

public class World {
	
	private Game game;
	private static int width, height; // in tiles
	private int spawnX, spawnY;
	private static List<List<Integer>> tiles;
	
	//private int[][] tiles;
	List<List<Integer>> quadrant1, quadrant2, quadrant3, quadrant4;
	private static List<List<Integer>> entities;
	
	public World(Game game, String path){
		this.game = game;
		//loadWorldFromFile(path);
		tiles = createWorld(70,70);
		setEntities(randomEntities(tiles.size(), tiles.get(0).size()));
		setEntity(10,10,2);
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
	
		
		int xStart = (int) Math.max(0, Game.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (Game.getGameCamera().getxOffset() + game.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, Game.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (Game.getGameCamera().getyOffset() + game.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for (int y = yStart; y < yEnd; y ++){
			for (int x = xStart; x < xEnd; x ++){
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - Game.getGameCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - Game.getGameCamera().getyOffset()));
				if (getEntity(x, y) != null && getEntity(x, y).getId() != 0){
					getEntity(x, y).render(g, (int) (x * Tile.TILE_WIDTH - Game.getGameCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - Game.getGameCamera().getyOffset()));
				}
			}
		}
		
	}
	
	public static void addRow(String side){
		ArrayList<Integer> newRow = new ArrayList<Integer>();
		for (int i = 0; i < tiles.get(0).size(); i ++){
			newRow.add((int) (Math.random() * 2));
		}
		
		if (side.equals("top")){
			tiles.add(0, newRow);
			addEntityRow("top");
		}
		else{
			tiles.add(newRow);
			addEntityRow("bottom");
			
		}
		height += 1;
	}
	
	public static void addColumn(String side){
		
		if (side.equals("right")){
			for (int i = 0; i < tiles.size(); i++){
				tiles.get(i).add((int) (Math.random() * 2));
			}
			addEntityColumn("right");
		}
		else{
			for (int i = 0; i < tiles.size(); i ++){
				tiles.get(i).add(0, (int) (Math.random() * 2));
			}
			addEntityColumn("left");
		}
		width += 1;
	}
	
	public static void addEntityRow(String side){
		ArrayList<Integer> newRow = new ArrayList<Integer>();
		for (int i = 0; i < tiles.get(0).size(); i ++){
			newRow.add((int) (Math.random() * 2));
		}
		
		if (side.equals("top")){
			getEntities().add(0, newRow);
		}
		else{
			getEntities().add(newRow);
		}
	}

	public static void addEntityColumn(String side){
		
		if (side.equals("right")){
			for (int i = 0; i < tiles.size(); i++){
				getEntities().get(i).add((int) (Math.random() * 0));
			}
		}
		else{
			for (int i = 0; i < tiles.size(); i ++){
				getEntities().get(i).add(0, (int) (Math.random() * 0));
			}
		}
	}
	
	public static Entity getEntity(int x, int y){
		//Entity e = Entity.entities[entities[y][x]];
		//entities = randomEntities(tiles.size(), tiles.get(0).size());
		try{
			Entity e = Entity.entities[getEntities().get(y).get(x)];
			if (e == null){
				return new NullEntity(0);
			}
			else
				return e;
		}catch(IndexOutOfBoundsException g){
			// System.out.println("World.java: getEntity() method: tried to get an entity at (" + x + ", " + y + ")");
			throw(g);
		}
	
		//return null;
		
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
		try{
			tiles.get(y).set(x, id);
		}catch(IndexOutOfBoundsException e){
			System.out.println("nope");
		}
	}
	
	public void setEntity(int x, int y, int id){
		getEntities().get(y).set(x, id);
	}
	
	private void loadWorldFromFile(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		for (int y = 0; y < height; y ++){
			for (int x = 0; x < width; x ++){
				tiles.get(x).set(y, Utils.parseInt(tokens[(x + y * width) + 4]));
			}
		}
	}
	
	private List<List<Integer>> createWorld(int worldWidth, int worldHeight){
		World.width = worldWidth;
		World.height = worldHeight;
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
			row = new ArrayList<Integer>();
			for (int j = 0; j < width; j ++){		
				row.add((int) (Math.random() * 1));
			}
			newWorld.set(i, row);
		}
		return newWorld;
	}
	
	// this should be a pretty temporary thing
	private List<List<Integer>> randomEntities(int height, int width){
		List<List<Integer>> entities = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < height; i ++){			
			
			List<Integer> row = new ArrayList<Integer>();
			
			for (int j = 0; j < width; j ++){
				//row.add((int)(Math.random() * 0));
				row.add(0);
			}	
			entities.add(row);
		}
		return entities;
	}
	
	public static int getWidth(){
		return width;
	}
	
	public static int getHeight(){
		return height;
	}

	public static List<List<Integer>> getEntities() {
		return entities;
	}

	public static void setEntities(List<List<Integer>> entities) {
		World.entities = entities;
	}

}
