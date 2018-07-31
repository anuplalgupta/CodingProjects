package practice;

public class KnightTourProblem {
	
	private int[][] board;
	private int n;
	
	private int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};
    
//  private int[] moveX = {1, 1, -1, -1, 2, 2, -2, -2};
//	private int[] moveY = {2, -2, 2, -2, 1, -1, 1, -1};
//	
	public KnightTourProblem(int n) {
		// TODO Auto-generated constructor stub
		this.n = n;
		board = new int[n][n];
		for(int i =0;i<n;i++) {
			for(int j =0;j<n;j++) {
				board[i][j] = -1;
			}
		}
		board[0][0] = 0;
	}
	
	public boolean isSafe(int i,int j) {
		
		if(i < 0 || j <0 || i>=n || j>=n || board[i][j] !=-1)
			return false;
		else
			return true;
	}
	public void printBoard() {
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(board[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	
	public boolean knightTour(int i, int j, int move) {
	
		//System.out.println("Move"+move);
		if(move == n * n) {
			//board[i][j] = move;
			return true;
		}
			
		for(int k =0;k<n;k++) {
			int nextX = i+moveX[k];
			int nextY = j+moveY[k];
			if(isSafe(nextX,nextY)) {
				board[nextX][nextY] = move;
				if(knightTour(nextX,nextY,move+1)) {
					return true;
				}
				else {
					board[nextX][nextY] = -1;
				}
				
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnightTourProblem kt = new KnightTourProblem(8);
		if(!kt.knightTour(0, 0, 1))
		{
			System.out.println("Knight Tour cant be completed with given co-ordinates");
		}
		kt.printBoard();
	}

}
