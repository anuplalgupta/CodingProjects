package practice;

import java.util.Scanner;


public class GuessTheNumber {
	
	private static final String RES_CORRECT = "CORRECT";
	private static final String RES_TOO_SMALL  = "TOO_SMALL";
	private static final String RES_TOO_BIG = "TOO_BIG";
	private static final String RES_WRONG_ANSWER = "WRONG_ANSWER";
	
	
	public static int guessNumber(int A, int B) {
		return ( A+B)/2;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int T;
		Scanner in = new Scanner(System.in);
		
		T = in.nextInt();
		while(T>0) {
			T--;
			int A,B;
			A = in.nextInt();
			B = in.nextInt();
			
			int N;
			N = in.nextInt();
			
			while(N >0) {
				N--;
				int Q = guessNumber(A+1,B);
				System.out.println(Q);
				String res = in.next();
				if(res.equals(RES_CORRECT))
					break;
				else if(res.equals(RES_TOO_SMALL))
					A = Q;
				else if(res.equals(RES_TOO_BIG))
					B = Q-1;
				else if(res.equals(RES_WRONG_ANSWER))
					return;
			}
		}
		in.close();
	}

}
