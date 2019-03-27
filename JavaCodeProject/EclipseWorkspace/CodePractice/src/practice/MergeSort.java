package com.practice.array.sort;

public class MergeSort {
	
	private int[] array;
	
	public void setArray(int[] arr){
		this.array = arr;
	}
	
	public void printArray(){
		for(int i =0;i< array.length;i++){
			System.out.println(array[i]);
		}
	}
	public void printArrayObject(){
		System.out.println("array is"+array);
	}
	
	public void merge(int startIndex, int endIndex){
		int firstArrayStartIndex = startIndex;
		int firstArrayEndIndex = (startIndex+endIndex)/2;
		int secondArrayStartIndex = firstArrayEndIndex +1;
		int secondArrayEndIndex = endIndex;
		
		int[] leftArray = new int [firstArrayEndIndex - firstArrayStartIndex + 1];
		int[] rightArray = new int [secondArrayEndIndex - secondArrayStartIndex +1];
		
		//copy data to left and right array
		for(int i = startIndex;i< endIndex; i++){
			if(i<=firstArrayEndIndex){
				leftArray[i-firstArrayStartIndex] = array[i];
			}else{
				rightArray[i-secondArrayStartIndex] = array[i];
			}
		}
		int i =0, j=0,k = startIndex;
		while(i<leftArray.length || j<rightArray.length){
			if(leftArray[i]<=rightArray[j]){
				array[k] = leftArray[i];
				i++;
			}else{
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
	}
	public void sortRecursive(int startIndex, int endIndex){
		if(startIndex >= endIndex){
			return;
		}
		int mid = (startIndex + endIndex)/2;
		sortRecursive(startIndex,mid);
		sortRecursive(mid+1,endIndex);
		
		merge(startIndex,endIndex);
		
	}
}
