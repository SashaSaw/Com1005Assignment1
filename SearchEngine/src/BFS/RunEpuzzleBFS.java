package BFS;

public class RunEpuzzleBFS {

	public static void main(String[] arg) {
		
		int[][] puzzleConfig = {{1,0,3},
								{4,2,6},
								{7,5,8}};
		
		int[][] target = {{1,2,3},
				{4,2,6},
				{7,5,8}};
		
		EpuzzleSearch searcher = new EpuzzleSearch(puzzleConfig, target);
		SearchState initState = (SearchState) new EpuzzleState(puzzleConfig[0][0],puzzleConfig[0][1],puzzleConfig[0][2],puzzleConfig[1][0],puzzleConfig[1][1],puzzleConfig[1][2],puzzleConfig[2][0],puzzleConfig[2][1],puzzleConfig[2][2]);
		
		String resb = searcher.runSearch(initState, "breadFirst");
		System.out.println(resb);
		
	}
}
