package practice;

import java.util.Scanner;

public class CodeChefATM2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		while(t>0) {
			t--;
			
			int n = in.nextInt();
			int k = in.nextInt();
			for(int i =0;i<n;i++) {
				int ai = in.nextInt();
				if(ai<=k) {
					System.out.print("1");
					k = k - ai; 
				}else {
					System.out.print("0");
				}
			}
			System.out.println("");
		}

	}

}
