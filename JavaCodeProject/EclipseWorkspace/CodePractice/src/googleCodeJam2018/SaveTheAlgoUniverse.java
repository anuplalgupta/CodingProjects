package googleCodeJam2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Q1
public class SaveTheAlgoUniverse {
	
	public static int damageFromSeq(String seq) {
		int damage =0;
		int beamStrength =1;
		for(int i =0;i<seq.length();i++) {
			if(seq.charAt(i)=='C') {
				beamStrength *= 2;
			}
			else {
				damage += beamStrength;
			}
		}
		return damage;
	}
	
	public static int minSwaps(String beamSeq, int D) {
		Map<Integer, Integer> chargeMap = new HashMap<>();
		int chargeCount =0;
		for(int i=0;i<beamSeq.length();i++) {
			if(beamSeq.charAt(i)=='C') {
				chargeCount++;
				chargeMap.put(chargeCount, i);
			}
		}
		int shootLength = beamSeq.length() - chargeCount;

		if(D<shootLength)
			return -1;

		int originalDamage = damageFromSeq(beamSeq);
		int numSwaps =0;
		int damageDiff = originalDamage -D;
		if(damageDiff <= 0) {
			return numSwaps;
		}
		
		for(int i = chargeCount;i>0;i--) {
			int swapsNeeded = (int) Math.ceil(damageDiff/Math.pow(2, i-1));
			int numPossibleSwap = (beamSeq.length()- 1) -(chargeCount - i)-chargeMap.get(i);
			
			if(swapsNeeded > numPossibleSwap) {
				
				numSwaps += numPossibleSwap;
				damageDiff -= Math.pow(2, i-1)*numPossibleSwap;
			}
			else {
				numSwaps += swapsNeeded;
				break;
			}
		}
		return numSwaps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T;
		Scanner input = new Scanner(System.in);
		
		T = input.nextInt();
		for(int i =1;i<=T;i++) {
			int D = input.nextInt();
			String beamSeq = input.next();
			int numSwaps = minSwaps(beamSeq,D);
			System.out.println("Case #"+i+": "+(numSwaps == -1 ? "IMPOSSIBLE" : numSwaps));
		}
		input.close();

	}

}
