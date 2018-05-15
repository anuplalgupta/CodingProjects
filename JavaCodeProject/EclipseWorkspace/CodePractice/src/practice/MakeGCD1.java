package practice;

import java.util.Scanner;

public class MakeGCD1 {
	
	public static int calculateGCD(int a, int b) {
		int small = a > b ? b : a;
		int large = a >b ? a:b;
		int remainder = large % small;
		
		if(remainder ==0)
			return small;
		else
			return calculateGCD(small,remainder);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int t;
		Scanner input = new Scanner(System.in);
		t = input.nextInt();
		while(t>0) {
			t--;
			int n = input.nextInt();
			
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = input.nextInt();
			
			int GCD = arr[0];
			for(int i=1;i<n;i++)
				GCD = calculateGCD(GCD,arr[i]);
			
			if(GCD == 1)
				System.out.println(0);
			else
				System.out.println(-1);
		}
		input.close();
	}

}
