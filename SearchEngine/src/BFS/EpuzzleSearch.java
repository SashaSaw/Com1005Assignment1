package BFS;

public class EpuzzleSearch extends Search{

	private int[][] puzzleConfig; // configuration of the puzzle in current state
	private int[][] target; // the configuration of the target puzzle state
	
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
