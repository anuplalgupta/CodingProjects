package practice;

import java.util.Scanner;

public class LargestContigeousSumArray {

	public static int calculateLCS(int[] arr) {
		int largestSum = arr[0];
		
		int[] dp = new int[arr.length];
		
		dp[0] = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			if (dp[i-1] > 0) 
				dp[i] = dp[i-1]+arr[i];
			else
				dp[i] = arr[i];
			
			if(dp[i]>largestSum)
				largestSum = dp[i];
		}
		
		return largestSum;
		
	}
	
	public static void main(String[] args) {
		int t;
		Scanner input = new Scanner(System.in);
		
		t = input.nextInt();
		
		while(t>0) {
			t--;
			int n = input.nextInt();
			int arr[] = new int[n];
			for(int i =0;i<n;i++) {
				arr[i] = input.nextInt();
			}
			System.out.println(calculateLCS(arr));
		}
	}
}
