package practice;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	
	public static boolean binarySearch(int[]arr, int startIndex, int endIndex, int val) {
		if(startIndex >= endIndex) {
			if(arr[startIndex]== val)
				return true;
			else 
				return false;
		}
		int mid = (startIndex+endIndex)/2;
		if(arr[mid]== val)
			return true;
		else if (val< arr[mid])
			return binarySearch(arr,startIndex,mid-1,val);
		else
			return binarySearch(arr, mid+1, endIndex,val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements in the array");
		
		int n = in.nextInt();
		
		int[] arr = new int[n];
		
		for(int i =0;i<n;i++) 
			arr[i] = in.nextInt();
		
		System.out.println("Enter the number to be searched");
		int val = in.nextInt();
		
		Arrays.sort(arr);
		
		if(binarySearch(arr,0, arr.length-1,val))
			System.out.println("value"+ val+"found");
		else
			System.out.println("value"+ val+"not found");
		
		in.close();
	}

}
