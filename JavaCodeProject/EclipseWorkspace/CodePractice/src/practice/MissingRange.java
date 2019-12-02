package practice;

import java.util.LinkedList;
import java.util.List;

class Solution1 {
    public String createRangeString(int a, int b){
        if(a == b){
            return Integer.toString(a);
        }
        return a+"->"+b;
    }
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        
        
        List<String> result = new LinkedList<>();
        
        //Boundry cases
        
        if(nums.length ==0){
            result.add(createRangeString(lower,upper));
            return result;
        }
        if(upper == lower){
            return result;
        }
        if(nums.length == 1){
            if(nums[0] == lower){
                result.add(createRangeString(lower+1,upper));
            }else if(nums[0] == upper){
                result.add(createRangeString(lower,upper-1));
            }else{
                result.add(createRangeString(lower,nums[0]-1));
                result.add(createRangeString(nums[0]+1, upper));
            }
            
            return result;
        }
        
        //add first segment
        if(lower < nums[0]){
            result.add(createRangeString(lower,nums[0]-1));
        }
        
        for(int i=0;i<nums.length-1;i++ ){
            if(nums[i+1] > nums[i]+1){
                result.add(createRangeString(nums[i]+1, nums[i+1]-1));
            }
        }
        
        //add last segment
        if(nums[nums.length-1]< upper){
            result.add(createRangeString(nums[nums.length-1]+1,upper));
        } 
        return result;
    }
}
public class MissingRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {-2147483648,-2147483648,0,2147483647,2147483647};
		int lower =	-2147483648;
		int upper =	2147483647;
		
		Solution1 sl = new Solution1();
		List<String> missingRange = sl.findMissingRanges(nums, lower, upper);
		System.out.println(missingRange);
		
	}

}
