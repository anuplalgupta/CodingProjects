package practice;

class SolutionCSK {
	public int subarraySum(int[] nums, int k) {
		int res =0;
		for(int i=0;i<nums.length;i++){
			int sum=0;
			for(int j=i;j<nums.length;j++){
				sum += nums[j];

				if(sum==k){
					res++;
					break;
				}else if(sum>k){
					break;
				}
			}
		}
		return res;
	}
}
public class ContigeousSumK
{
	public static void main(String[] args){
		SolutionCSK sol = new SolutionCSK();
		int k = 100;
		int[] arr = {28,54,7,-70,22,65,-6};

		System.out.println(sol.subarraySum(arr,k));
	}
}
