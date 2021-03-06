package googleCodeJam2018;

import java.util.Scanner;

public class TroubleSort {
	
	public static void tripleSwap(int[]arr,int  index) {
		//to avoid arraryIndexOutofBound
		if(arr == null || arr.length < index+2+1)
			return;
		
		int temp = arr[index];
		arr[index]= arr[index+2];
		arr[index+2] = temp;
		return;
	}
	
	public static void troubleSort(int[] arr) {
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i =0;i<arr.length-2;i++) {
				if(arr[i]>arr[i+2]) {
					sorted = false;
					tripleSwap(arr,i);
				}
			}
		}
	}
	public static void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i+"  ");
		}
	}

	public static void main(String[] args) {
		
		int T;
		Scanner input = new Scanner(System.in);
		T = input.nextInt();
		for(int i =1;i<=T;i++) {
			int n;
			n = input.nextInt();
			int[] arr = new int[n];
			
			for(int j=0;j<n;j++) {
				arr[j] = input.nextInt();
			}
			troubleSort(arr);
			printArray(arr);
			int k;
			for(k=0;k<n-1;k++) {
				if(arr[k]>arr[k+1])
					break;
			}
			System.out.println("Case #"+i+": "+(k==n-1?"OK":k));
		}
			
		// TODO Auto-generated method stub

	}

}
