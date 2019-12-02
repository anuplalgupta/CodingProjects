package googleCodeJam19;

import java.util.Scanner;

public class ForegoneSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int testNo = 1;testNo<=t;testNo++) {
			String n = in.next();
			
			StringBuilder a = new StringBuilder(n);
			StringBuilder b = new StringBuilder(n);
			
			for(int i =0;i<n.length();i++) {
				if(n.charAt(i) != '4') {
					a.setCharAt(i, n.charAt(i));
					b.setCharAt(i, '0');
				}else {
					a.setCharAt(i, '2');
					b.setCharAt(i, '2');
				}
				
			}
			
			System.out.println("Case #"+testNo+": "+a+" "+b);
			
			
		}
		in.close();

	}

}
