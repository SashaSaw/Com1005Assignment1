package BFS;

public class RunEpuzzleBFS {

	public static void main(String[] arg) {
		
		int[][] puzzleConfig1 = {{1,2,3},
								{4,0,6},
								{7,5,8}};
		
		int[][] puzzleConfig2 = {{4,1,3},
								{7,2,5},
								{0,8,6}};
		
		int[][] puzzleConfig3 = {{2,3,6},
								{1,5,8},
								{4,7,0}};
		
		int[][] target = {{1,2,3},
				{4,2,6},
				{7,5,8}};
		
		EpuzzleSearch searcher1 = new EpuzzleSearch(puzzleConfig1, target);
		EpuzzleSearch searcher2 = new EpuzzleSearch(puzzleConfig1, target);
		EpuzzleSearch searcher3 = new EpuzzleSearch(puzzleConfig1, target);
		SearchState initState1 = (SearchState) new EpuzzleState(puzzleConfig1[0][0],puzzleConfig1[0][1],puzzleConfig1[0][2],
																puzzleConfig1[1][0],puzzleConfig1[1][1],puzzleConfig1[1][2],
																puzzleConfig1[2][0],puzzleConfig1[2][1],puzzleConfig1[2][2]);
		SearchState initState2 = (SearchState) new EpuzzleState(puzzleConfig2[0][0],puzzleConfig2[0][1],puzzleConfig2[0][2],
																puzzleConfig2[1][0],puzzleConfig2[1][1],puzzleConfig2[1][2],
																puzzleConfig2[2][0],puzzleConfig2[2][1],puzzleConfig2[2][2]);
		SearchState initState3 = (SearchState) new EpuzzleState(puzzleConfig3[0][0],puzzleConfig3[0][1],puzzleConfig3[0][2],
																puzzleConfig3[1][0],puzzleConfig3[1][1],puzzleConfig3[1][2],
																puzzleConfig3[2][0],puzzleConfig3[2][1],puzzleConfig3[2][2]);
		
		String resb1 = searcher1.runSearch(initState1, "breadFirst");
		String resb2 = searcher1.runSearch(initState2, "breadFirst");
		String resb3 = searcher1.runSearch(initState3, "breadFirst");
		System.out.println(resb1);
		//System.out.println(resb2);
		//System.out.println(resb3);
		
	}
}
