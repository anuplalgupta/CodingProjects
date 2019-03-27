package practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class GridCell{
	int i,j;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public GridCell(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

}
class ShoretesPathToObstacle {	

	public static int returnLevelForVal(int[][]arr, int val) {
		Queue<GridCell> lotQ = new LinkedList<GridCell>();
		int level = 0;
		GridCell initialCell =  new GridCell(0,0);
		lotQ.add(initialCell);
		lotQ.add(new GridCell(-1, -1));
		Set<GridCell> visited = new HashSet<GridCell>();
		
		while(!lotQ.isEmpty()) {
			GridCell qHeadVal = lotQ.poll();
			if(valAt(arr,qHeadVal) == val) {
				return level;
			}
			level = populateQ(arr,lotQ, qHeadVal, visited,level);
		}
		
		return -1;
	}

	public static int populateQ(int[][] arr, Queue<GridCell> lotQ, GridCell qHeadVal, Set<GridCell> visited, int level) {
		int lvl = level;
		int i = qHeadVal.getI();
		int j = qHeadVal.getJ();
		if(i==-1 && j== -1) {
			//level delimiter
			lotQ.add(new GridCell(-1,-1));
			lvl++;
		}
		if(isEligible(arr, i+1, j, visited,arr.length, arr[0].length)) {
			lotQ.add(new GridCell(i+1, j));
		}
		if(isEligible(arr, i-1, j, visited, arr.length, arr[0].length)) {
			lotQ.add(new GridCell(i-1, j));
		}
		if(isEligible(arr, i, j+1, visited, arr.length, arr[0].length)) {
			lotQ.add(new GridCell(i, j+1));
		}
		if(isEligible(arr, i, j-1, visited, arr.length, arr[0].length)) {
			lotQ.add(new GridCell(i, j-1));		
		}
		
		visited.add(qHeadVal);
		
		return lvl;
	}

	public static boolean isEligible(int[][] arr, int i, int j, Set<GridCell> visited, int length, int length2) {

		if(i<0 || j<0 || i >= length || j>= length2 ||visited.contains(new GridCell(i, j))) {
			return false;
		}
		if(arr[i][j] == 0) {
			return false;
		}
		return true;
	}

	public static int valAt(int[][] arr, GridCell gridCell) {
		int i = gridCell.getI();
		int j = gridCell.getJ();

		if(i<0 || j<0 || i>= arr.length || j>= arr[0].length) {
			return -1;
		}
		
		return arr[i][j];
	}
	
	public static void main(String[] argst) {
		int arr[][] = {{1,0,9,1},
						{1,0,0,1},
						{1,1,1,1}};
		System.out.println(returnLevelForVal(arr, 9));
	}

}




