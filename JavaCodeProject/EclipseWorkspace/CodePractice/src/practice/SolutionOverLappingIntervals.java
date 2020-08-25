package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


class OverlappingIntervals {

	public int compare(int[] a, int[] b){
		int la = a[0];
		int ra = a[1];

		int lb = b[0];
		int rb = b[1];

		if(ra < lb){
			return -1;
		}
		if(rb < la){
			return 1;
		}
		return 0;
	}


	public Integer[] overlap(int[] a, int[] b){
		int la = a[0];
		int ra = a[1];

		int lb = b[0];
		int rb = b[1];

		Integer[] res = new Integer[2];

		res[0] = Math.max(la,lb);
		res[1] = Math.min(ra,rb);

		return res;
	}
	public int[][] intervalIntersection(int[][] A, int[][] B) {

		int m = A.length;
		int n = B.length;

		int i=0;
		int j =0;

		List<Integer[]> res = new ArrayList<>();

		while(i<m && j<n){

			int compareRes = compare(A[i], B[j]);

			if(compareRes==0){

				res.add(overlap(A[i], B[j]));

				if(A[i][1]<B[j][1]){
					i++;
				}else{
					j++;
				}
			}else if(compareRes<0){
				i++;
			}else{
				j++;
			}

		}

		int[][] result = new int[res.size()][2];

		for(int index =0;index<res.size();index++){
			result[index][0] = res.get(index)[0];
			result[index][1] = res.get(index)[1];
		}
		return result;
	}

}

public class SolutionOverLappingIntervals {



	public static void main(String[] args)
	{
		int[][] a = {{0,2},{5,10},{13,23},{24,25}};
		int[][] b = {{1,5},{8,12},{15,24},{25,26}};
		OverlappingIntervals intervals = new OverlappingIntervals();
		int[][] res = intervals.intervalIntersection(a, b);

		System.out.println(String.valueOf(res));
	}
}