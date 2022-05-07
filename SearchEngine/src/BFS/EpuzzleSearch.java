package BFS;

public class EpuzzleSearch extends Search{

	private int[][] puzzleConfig = new int [3][3]; // configuration of the puzzle in current state
	private int[][] target = new int [3][3]; // the configuration of the target puzzle state
	
	public EpuzzleSearch (int[][] puzzleC, int[][] tar) {
		
		puzzleConfig = puzzleC;
		target = tar;
	}
	
	// accessor for puzzle configuration
	public int[][] getPuzzleConfig() {
		return puzzleConfig;
	}
	
	//accessor for target puzzle configuration
	public int[][] getTarget() {
		return target;
	}
	
}
