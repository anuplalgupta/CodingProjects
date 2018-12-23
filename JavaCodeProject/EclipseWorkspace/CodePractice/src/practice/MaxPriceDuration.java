package practice;

import java.util.Stack;

public class MaxPriceDuration {
	
	public static int[] maxPriceForDuration(int[] dailyPrices) {
		
		int[] result = new int[dailyPrices.length];
		Stack<Integer> higherPrices = new Stack<Integer>();
		
		result[0] = 1;
		higherPrices.push(0);
		
		
		for(int i =1;i<dailyPrices.length;i++) {
			result[i] = 1;
			//System.out.println("daily price \t"+dailyPrices[i] + "\t max Price before is  \t"+higherPrices.peek() );
			while(higherPrices.size() >0 && dailyPrices[i] > dailyPrices[higherPrices.peek()]) {
				result[i] = result[i] + result[higherPrices.pop()];
			}
			higherPrices.push(i);
			//System.out.println("daily price \t"+dailyPrices[i] + "\t max duration \t"+result[i] );
//			for(Integer p : higherPrices)
//				System.out.println(dailyPrices[p]);
		}
		return result;
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dailyPrices = { 1, 2, 3, 9, 10, 6, 5, 11};
		
		int[] result = maxPriceForDuration(dailyPrices); 
		
		for(int i : result)
			System.out.print(i+"\t");
		

	}

}
