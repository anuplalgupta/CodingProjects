package com.practice.array.sort;

public class MainSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort mergeSort = new MergeSort();
		int arr[] = {1,3,4,2};
		mergeSort.setArray(arr);
		mergeSort.printArray();
		mergeSort.sortRecursive(0, arr.length);
		mergeSort.printArray();

	}

}
