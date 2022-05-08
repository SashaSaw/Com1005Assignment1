package BFS;

import java.util.ArrayList;

public class EpuzzleState extends SearchState{
	
	private int topLeft; 	// stores number in the top left of the 3x3 grid
	private int top;		// stores number in the top of the 3x3 grid
	private int topRight;	// stores number in the top right of the 3x3 grid
	private int middleLeft;	// stores number in the middle left of the 3x3 grid
	private int middle;		// stores number in the middle of the 3x3 grid
	private int middleRight;// stores number in the middle right of the 3x3 grid
	private int bottomLeft;	// stores number in the bottom left of the 3x3 grid
	private int bottom;		// stores number in the bottom of the 3x3 grid
	private int bottomRight;// stores number in the bottom right of the 3x3 grid
	
	public EpuzzleState(int tL, int t, int tR, int mL, int m, int mR, int bL, int b, int bR) {
		topLeft = tL;
		top = t;
		topRight = tR;
		middleLeft = mL;
		middle = m;
		middleRight = mR;
		bottomLeft = bL;
		bottom = b;
		bottomRight = bR;
	}

	public int getTopLeft() {
		return topLeft;
	}

	public int getTop() {
		return top;
	}

	public int getTopRight() {
		return topRight;
	}

	public int getMiddleLeft() {
		return middleLeft;
	}

	public int getMiddle() {
		return middle;
	}

	public int getMiddleRight() {
		return middleRight;
	}

	public int getBottomLeft() {
		return bottomLeft;
	}

	public int getBottom() {
		return bottom;
	}

	public int getBottomRight() {
		return bottomRight;
	}

	@Override
	public String toString() {
		return "EpuzzleState \n" + topLeft + " | " + top + " | " + topRight + "\n" +
				"----------\n" + 
				middleLeft + " | " + middle + " | " + middleRight + "\n" + 
				"----------\n" + 
				bottomLeft + " | " + bottom + " | " + bottomRight;
	}

	@Override
	boolean goalPredicate(Search searcher) {
		EpuzzleSearch esearcher = (EpuzzleSearch) searcher;
		int [][] tar = esearcher.getTarget();
		if((topLeft == tar[0][0]) && (top == tar[0][1]) && (topRight == tar[0][2]) &&
			(middleLeft == tar[1][0]) && (middle == tar[1][1]) && (middleRight == tar[1][2]) &&
			(bottomLeft == tar[2][0]) && (bottom == tar[2][1]) && (bottomRight == tar[2][2])) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	ArrayList<SearchState> getSuccessors(Search searcher) {
		EpuzzleSearch eSearcher = (EpuzzleSearch) searcher;
		int[][] puzzleConfig = eSearcher.getPuzzleConfig();
		
		int xOfEmpty = 0;
		int yOfEmpty = 0;
		for(int i=0; i<3;i++) {
			for(int j=0; j<3;j++) {
				if(puzzleConfig[i][j]==0) {
					xOfEmpty = i;
					yOfEmpty = j;
				}
			}
		}
		
		ArrayList<EpuzzleState> eslis = new ArrayList<EpuzzleState>();
		ArrayList<SearchState> slis = new ArrayList<SearchState>();
		
		
		int[][] swappedPuzzleConfig = new int[3][3];
		int elementToBeSwapped;
		
		//all have nodes to the right (must be swapped with node to right)
		if(xOfEmpty==0||xOfEmpty==1) {
			elementToBeSwapped = puzzleConfig[yOfEmpty][xOfEmpty+1];
			for(int i = 0;i<3;i++) {
				for(int j = 0;j<3;j++) {
					if(j==xOfEmpty+1 && i==yOfEmpty) {
						swappedPuzzleConfig[i][j]=0;
					}
					else {
						swappedPuzzleConfig[i][j]=puzzleConfig[i][j];
					}
				}
			}
			swappedPuzzleConfig[xOfEmpty][yOfEmpty]=elementToBeSwapped;
			
			eslis.add(new EpuzzleState(swappedPuzzleConfig[0][0],swappedPuzzleConfig[0][1],swappedPuzzleConfig[0][2],swappedPuzzleConfig[1][0],swappedPuzzleConfig[1][1],swappedPuzzleConfig[1][2],swappedPuzzleConfig[2][0],swappedPuzzleConfig[2][1],swappedPuzzleConfig[2][2]));
		}
		
		//all have nodes to the left (must be swapped with node to left)
		if(xOfEmpty==1||xOfEmpty==2) {
			elementToBeSwapped = puzzleConfig[yOfEmpty][xOfEmpty-1];
			for(int i = 0;i<3;i++) {
				for(int j = 0;j<3;j++) {
					if(j==xOfEmpty-1 && i==yOfEmpty) {
						swappedPuzzleConfig[i][j]=0;
					}
					else {
						swappedPuzzleConfig[i][j]=puzzleConfig[i][j];
					}
				}
			}
			swappedPuzzleConfig[xOfEmpty][yOfEmpty]=elementToBeSwapped;
			
			eslis.add(new EpuzzleState(swappedPuzzleConfig[0][0],swappedPuzzleConfig[0][1],swappedPuzzleConfig[0][2],swappedPuzzleConfig[1][0],swappedPuzzleConfig[1][1],swappedPuzzleConfig[1][2],swappedPuzzleConfig[2][0],swappedPuzzleConfig[2][1],swappedPuzzleConfig[2][2]));
		}
		
		//all have nodes below (must be swapped with node below)
		if(yOfEmpty==0||yOfEmpty==1) {
			elementToBeSwapped = puzzleConfig[yOfEmpty+1][xOfEmpty];
			for(int i = 0;i<3;i++) {
				for(int j = 0;j<3;j++) {
					if(j==xOfEmpty && i==yOfEmpty+1) {
						swappedPuzzleConfig[i][j]=0;
					}
					else {
						swappedPuzzleConfig[i][j]=puzzleConfig[i][j];
					}
				}
			}
			swappedPuzzleConfig[xOfEmpty][yOfEmpty]=elementToBeSwapped;
			
			eslis.add(new EpuzzleState(swappedPuzzleConfig[0][0],swappedPuzzleConfig[0][1],swappedPuzzleConfig[0][2],swappedPuzzleConfig[1][0],swappedPuzzleConfig[1][1],swappedPuzzleConfig[1][2],swappedPuzzleConfig[2][0],swappedPuzzleConfig[2][1],swappedPuzzleConfig[2][2]));
		}
		
		//all have nodes above (must be swapped with node above)
		if(yOfEmpty==1||yOfEmpty==2) {
			elementToBeSwapped = puzzleConfig[yOfEmpty-1][xOfEmpty];
			for(int i = 0;i<3;i++) {
				for(int j = 0;j<3;j++) {
					if(j==xOfEmpty && i==yOfEmpty-1) {
						swappedPuzzleConfig[i][j]=0;
					}
					else {
						swappedPuzzleConfig[i][j]=puzzleConfig[i][j];
					}
				}
			}
			swappedPuzzleConfig[xOfEmpty][yOfEmpty]=elementToBeSwapped;
			
			eslis.add(new EpuzzleState(swappedPuzzleConfig[0][0],swappedPuzzleConfig[0][1],swappedPuzzleConfig[0][2],swappedPuzzleConfig[1][0],swappedPuzzleConfig[1][1],swappedPuzzleConfig[1][2],swappedPuzzleConfig[2][0],swappedPuzzleConfig[2][1],swappedPuzzleConfig[2][2]));
		}
		
		for (EpuzzleState es : eslis) {
			slis.add((SearchState) es);
		}
		
		return slis;
	}

	@Override
	boolean sameState(SearchState n2) {
		EpuzzleState es2 = (EpuzzleState)n2;
		
		return ((topLeft == es2.getTopLeft()) && (top == es2.getTop()) && (topRight == es2.getTopRight()) &&
				(middleLeft == es2.getMiddleLeft()) && (middle == es2.getMiddle()) && (middleRight == es2.getMiddleRight()) &&
				(bottomLeft == es2.getBottomLeft()) && (bottom == es2.getBottom()) && (bottomRight == es2.getBottomRight()));
	}

}
