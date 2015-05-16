
public class RayTracing {
	
	// this class works by taking a 2d array as input, and also the two coordinates of the line that's being traced
	
	private int[][] map;
	private int tileWidth;
	private int tileHeight;
	private int[] illegalTiles;
	
	
	/*
	 * @param	map				the 2D array that represents the values of all the tiles on the actual map
	 * @param	tileWidth		the width of all the tiles on the actual map
	 * @param	tileHeight		the height of all the tiles on the actual map
	 * @param	illegalTiles	all the tiles that cannot be walked on
	 */
	public RayTracing(int[][] map, int tileWidth, int tileHeight, int[] illegalTiles){
		this.map = map;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.illegalTiles = illegalTiles;
	}

	public void trace(int[] point1, int[] point2){
		
		
		
		
	}
	
	public boolean isIllegal(int tile){
		for (int i = 0; i < illegalTiles.length; i ++){
			if (illegalTiles[i] == tile){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
