package practice;

import java.util.Scanner;

public class RearrangeNegativePositives {
	


	public static void reversePositive(int[] arr, int startIndex, int endIndex){
		
		if(arr[endIndex] <0)
			return;
		int positiveStart = startIndex;
		for(;arr[positiveStart] <0;positiveStart++);
	
		for(int i = positiveStart,j=endIndex;i<j;i++,j--){
			int temp = arr[i];
			arr[i]=arr[j];
			arr[j] = temp;
		}
	}
	
	
	public static void reverseNegative(int[] arr, int startIndex, int endIndex){
		
		if(startIndex == endIndex)
			return;
		
		if(arr[startIndex] >0)
			return;
		int negativeEnd = startIndex;
		for(;arr[negativeEnd] <0 && negativeEnd <=endIndex ;negativeEnd++);
	
		negativeEnd --;
		for(int i = startIndex,j=negativeEnd;i<j;i++,j--){
			int temp = arr[i];
			arr[i]=arr[j];
			arr[j] = temp;
		}
	}
	
	public static void reverseLpRn(int[] arr, int startIndex, int endIndex){
		
		if(arr[endIndex] <0)
			return;
		
		int positiveStart = startIndex;
		for(;arr[positiveStart]<0 && positiveStart <= endIndex ;positiveStart++);
		
		int negativeEnd = positiveStart +1;
		
		if(negativeEnd > endIndex)
			return;
		
		for(;arr[negativeEnd] <0 && negativeEnd <= endIndex; negativeEnd++)
			;
		negativeEnd --;
		for(int i=positiveStart, j=negativeEnd;i<j;i++,j--){
			int temp = arr[i];
			arr[i]= arr[j];
			arr[j] = temp;
		}
	}
	
	public static void printArray(int[] arr){
		for(int i : arr){
			System.out.print(i+"  ");
		}
		System.out.println("");
	}
		
	
	public static void rearrange(int[] arr, int startIndexL, int endIndexL, int startIndexR, int endIndexR){
		reversePositive(arr, startIndexL, endIndexL);
		reverseNegative(arr, startIndexR, endIndexR);
		
		reverseLpRn(arr,startIndexL, endIndexR);
		
		return;
	}
	
	
	public static void mergeRearrange(int[]arr, int startIndex, int endIndex){
		
		printArray(arr);
		if(startIndex == endIndex)
			return;
		
		int mid = (startIndex + endIndex)/2;
		mergeRearrange(arr, startIndex, mid);
		mergeRearrange(arr, mid+1, endIndex);
		
		rearrange(arr,startIndex,mid, mid+1, endIndex);
		return;
	}
	// -9 4 -8 3 -10
	
	public static void rearrangeNegativePositive(int[] arr){
		//varient of merge sort logic.
		//LnLpRnRp -->revert Lp and Rn --> LnLp'Rn'Rp
		//revert the Lp'Rn' together -->LnRnLpRp
		
		
		mergeRearrange(arr,0,arr.length -1);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner in = new Scanner(System.in);
		System.out.println("enter total number of elements in the array");
		n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = in.nextInt();
		}
		rearrangeNegativePositive(arr);
		
		

	}

}
