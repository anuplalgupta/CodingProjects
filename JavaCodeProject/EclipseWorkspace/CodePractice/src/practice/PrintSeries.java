package practice;

import java.util.Scanner;

/*Print all numbers satisfying the expression 2^i * 5^j (where i, j are integers i >= 0 and j >= 0) in increasing order up to a given bound N. 
2^i stands for power(2, i).*/

public class PrintSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		int number =1;
		System.out.println(number);
		number *=2;
		System.out.println(number);
		
		while(number <= n) {
			number *=2;
			if(number > n)
				break;
			System.out.println(number);
			number /=4;
			number *=5;
			if(number > n)
				break;
			
			System.out.println(number);
			number /=5;
			number *=4;
		}
		
		input.close();
	}

}
