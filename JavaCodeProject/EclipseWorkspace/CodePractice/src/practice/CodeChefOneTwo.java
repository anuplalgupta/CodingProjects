package practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeChefOneTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		while(t>0) {
			t--;
			int n = in.nextInt();
			
			int arr[] = new int[n];
			int sum[] = new int[n];
			for(int i =0;i<n;i++) {
				arr[i] = in.nextInt();
				if(i==0) {
					
					sum[i] = arr[i];
					continue;
				}
				sum[i] = sum[i-1]+arr[i];
			}
			
		}

	}

}
