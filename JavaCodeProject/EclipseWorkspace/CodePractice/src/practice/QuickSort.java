package practice;

public class QuickSort{
	public static void quickSortRec(int[] arr, int start, int end){
		if(end<=start)
			return;
		
		int pivotIndex = partition(arr,start,end);
		quickSortRec(arr,start,pivotIndex-1);
		quickSortRec(arr,pivotIndex+1,end);
	}
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int partition(int[]arr, int start,int end){
		printArray(arr);
		//track lower number by an integer and traverse higher
		int pivot = arr[end];
		int lowerindex = start;
		for(int i = start;i<=end-1;i++){
			if(arr[i]< pivot){
				swap(arr,i,lowerindex);
				lowerindex++;
			}
		}
		swap(arr,lowerindex,end);
		return lowerindex;
	}
	public static void printArray(int[] arr) {
		for(int i =0;i<arr.length;i++)
			System.out.print(arr[i]);
		System.out.println("");
	}
	
	public static void main(String args[]){
		int[] arr = {-5,9,3,1,7,0,8,4,6,2};
		
		quickSortRec(arr,0,arr.length-1);
		
	}
}
		
			
				
		
