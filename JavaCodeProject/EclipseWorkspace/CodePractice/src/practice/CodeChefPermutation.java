package practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeChefPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		while(t>0) {
			t--;
			int n = in.nextInt();
			
			Set<Integer> rangeSet = new HashSet<>();
			int count =0;
			for(int i =0;i<n;i++) {
				
				int val = in.nextInt();
				
				if(val>=1 && val<=n) {
					if(rangeSet.contains(val))
						continue;
					else {
						rangeSet.add(val);
						count++;
					}
				}
			}
			System.out.println(n-count);
			
			
		}

	}

}
