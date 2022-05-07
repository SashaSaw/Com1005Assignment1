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
		SearchState initState = (SearchState) new EpuzzleState();
		
		String resb = searcher.runSearch(initState, "breadFirst");
		System.out.println(resb);
		
	}
}
