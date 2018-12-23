package practice;

import java.util.Scanner;

public class Kadanes {
	
	
	public static int largestContiguousSum(int [] arr) {
		
		int[] contiguousSumArray = new int[arr.length];
		contiguousSumArray[0] = arr[0];
		
		int	largestSum = contiguousSumArray[0];
		
		
		for(int i =1;i<arr.length;i++) {
			if(contiguousSumArray[i-1]+arr[i]> arr[i]) {
				contiguousSumArray[i] = contiguousSumArray[i-1]+arr[i]; 
			}else {
				contiguousSumArray[i] = arr[i];
			}
			
			if(largestSum < contiguousSumArray[i]) {
				largestSum = contiguousSumArray[i];
			}
		}
		
		
		return largestSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		while(t>0) {
			
			int n = in.nextInt();
			int testArr[] = new int[n]; 
			for(int i =0;i<n;i++) {
				testArr[i] = in.nextInt();
			}
			System.out.println(largestContiguousSum(testArr));
		}
		in.close();
	}
}
