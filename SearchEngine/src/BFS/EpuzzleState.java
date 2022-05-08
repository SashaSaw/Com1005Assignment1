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
		topLeft = tL; 		//content of the top Left section of grid
		top = t;			//content of the top section of grid
		topRight = tR;		//content of the top Right section of grid
		middleLeft = mL;	//content of the middle Left section of grid
		middle = m;			//content of the middle section of grid
		middleRight = mR;	//content of the middle Right section of grid
		bottomLeft = bL;	//content of the bottom Left section of grid
		bottom = b;			//content of the bottom section of grid
		bottomRight = bR;	//content of the bottom Right section of grid
	}

	//Accessor methods for differents section of the puzzle grid
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

	//to string
	@Override
	public String toString() {
		return "EpuzzleState \n" + topLeft + " | " + top + " | " + topRight + "\n" +
				"----------\n" + 
				middleLeft + " | " + middle + " | " + middleRight + "\n" + 
				"----------\n" + 
				bottomLeft + " | " + bottom + " | " + bottomRight;
	}

	//checks if current node is equal to the target node by comparing each sections of the grids
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
		
		//finds the coordinates of the empty square in the puzzle
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
		
		//list of Epuzzle states
		ArrayList<EpuzzleState> eslis = new ArrayList<EpuzzleState>();
		ArrayList<SearchState> slis = new ArrayList<SearchState>();
		
		
		int[][] swappedPuzzleConfig = new int[3][3];
		int elementToBeSwapped;
		
		//swaps the empty square with the square to its right and adds new Epuzzle state
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
		
		//swaps the empty square with the square to its left and adds new Epuzzle state
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
		
		//swaps the empty square with the square below it and adds new Epuzzle state
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
		
		//swaps the empty square with the square above it and adds new Epuzzle state
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
		
		//casts the Epuzzle States as search States in slis
		for (EpuzzleState es : eslis) {
			slis.add((SearchState) es);
		}
		
		return slis;
	}

	//Same state - do two Epuzzle nodes have the exact same grid configuration
	@Override
	boolean sameState(SearchState n2) {
		EpuzzleState es2 = (EpuzzleState)n2;
		
		return ((topLeft == es2.getTopLeft()) && (top == es2.getTop()) && (topRight == es2.getTopRight()) &&
				(middleLeft == es2.getMiddleLeft()) && (middle == es2.getMiddle()) && (middleRight == es2.getMiddleRight()) &&
				(bottomLeft == es2.getBottomLeft()) && (bottom == es2.getBottom()) && (bottomRight == es2.getBottomRight()));
	}

}
