package practice;


class Solution30 {
	//[4,5,6,7,8,1,2,3] ==>5
	//[6,7,1,2,3,4,5]  ==>6
	//[4,5,6,7,0,1,2]==>3
	public int customBinSearch(int[] arr, int tgt, int left, int right){

		if(left<0 || right>= arr.length || left>right){
			return -1;
		}
		int mid = (left+right)/2;
		if(arr[mid]==tgt){
			return mid;
		}
		if(left==right){
			return -1;
		}

		//if mid in left side of rotation
		if(arr[mid]>arr[left]){
			if(arr[mid]>tgt && tgt >=arr[left]){
				return customBinSearch(arr,tgt,left,mid-1);
			}else{
				return customBinSearch(arr,tgt,mid+1, right);
			}
		}else{//right sid of rotation
			if(tgt>arr[mid] && tgt<=arr[right]){
				return customBinSearch(arr,tgt,mid+1,right);
			}else{
				return customBinSearch(arr,tgt,left,mid-1);
			}
		}


	}
	public int search(int[] nums, int target) {
		return customBinSearch(nums,target,0,nums.length-1);
	}
}
public class BinSearchRoatatedArray
{
	public static void main(String[] args){
		Solution30 sol = new Solution30();
		int[] arr = new int[]{4,5,6,7,0,1,2};
		System.out.println(sol.search(arr,0));
	}
}
