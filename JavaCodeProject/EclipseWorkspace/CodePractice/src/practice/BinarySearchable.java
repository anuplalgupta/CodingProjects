package practice;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BinarySearchable {

	public static void binarySearchableDnC(int[] nums, List<Integer> res, int li, int ri, int left, int right){
		if(ri<li){
			return;
		}
		int mid = (li+ri)/2;
		if(nums[mid]<  right && nums[mid]> left ){
			res.add(nums[mid]);
		}
		if(li == ri){
			return;
		}
		binarySearchableDnC(nums,res,li,mid-1,left,nums[mid]);
		binarySearchableDnC(nums,res,mid+1,ri,nums[mid],right);

	}
	public static List<Integer> binarySearchable(int[] nums){
		List<Integer> res = new ArrayList<>();
		binarySearchableDnC(nums,res,0,nums.length-1,Integer.MIN_VALUE, Integer.MAX_VALUE);
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i =0;i<n;i++){
			nums[i] = sc.nextInt();
		}
		List<Integer> res = binarySearchable(nums);
		System.out.println(res);
	}
}