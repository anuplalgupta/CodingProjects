package googleCodeJam19;

import java.util.Scanner;

public class GoOwnWay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int testNo = 1;testNo<=t;testNo++) {
			int n = in.nextInt();
			
			String lway = in.next();
			
			StringBuilder mWay = new StringBuilder();

			int lS = 0, lE=0, mS=0, mE=0;
			
			for(int i =0;i<lway.length();i++) {
				
				
				if(lway.charAt(i)=='E'){
			        mWay.append('S');
			    }else{
			        mWay.append('E');
			    }

			}
			System.out.println("Case #"+testNo+": "+mWay);
		}
	}

}
