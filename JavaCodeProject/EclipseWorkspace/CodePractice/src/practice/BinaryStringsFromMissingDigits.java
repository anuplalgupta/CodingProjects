package practice;

import java.util.Scanner;
import java.util.logging.Logger;


public class BinaryStringsFromMissingDigits {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int t;
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		while(t>0) {
			t--;
			String pattern = in.next();
			
			printAllPatterns(pattern);
			
		}

	}

	private static void printAllPatterns(String pattern) {
		// TODO Auto-generated metod stub
			String zeroReplace = pattern.replaceFirst("\\?", "0");
			if(zeroReplace.equals(pattern)) {
				System.out.println(pattern);
				return;
			}
			String oneReplace = pattern.replaceFirst("\\?", "1");
			printAllPatterns(zeroReplace);
			printAllPatterns(oneReplace);
	}

}
