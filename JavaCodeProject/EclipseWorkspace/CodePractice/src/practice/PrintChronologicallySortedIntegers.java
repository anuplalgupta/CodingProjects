package practice;

import java.util.Scanner;

public class PrintChronologicallySortedIntegers {
	
	public static void printDictionarySortInt(int val, int upperBound)
	{
		if(val>upperBound)
			return;
		System.out.println(val);
		
		val *=10;
		printDictionarySortInt(val,upperBound);
		
		val = (int)val/10;
		
		val++;
		if(val %10 ==0)
			return;	
		printDictionarySortInt(val,upperBound);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		if(n<1)
			System.out.println(n);
		int numPrint = 1;
		
		printDictionarySortInt(numPrint,n);
		
		in.close();

	}

}
