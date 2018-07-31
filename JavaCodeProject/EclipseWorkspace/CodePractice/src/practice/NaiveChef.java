package practice;

import java.util.Scanner;


public class NaiveChef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while(t>0) {
			t--;
			int n, a,b;
			n = input.nextInt();
			a = input.nextInt();
			b = input.nextInt();
			int aOccuranceFace =0;
			int bOccuranceFace = 0;
			for(int i =0;i<n;i++) {
				int face = input.nextInt();
				if(face == a)
					aOccuranceFace++;
				if(face ==b)
					bOccuranceFace++;
			}
			System.out.println((double)(aOccuranceFace*bOccuranceFace)/(n*n));
		}
		
		
		
		
		input.close();

	}

}
