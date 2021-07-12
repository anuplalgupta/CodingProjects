package practice;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {

        int end = 0;
        int num = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= num) {
                num = nums[i];
            } else {
                end = i;
            }
        }
        int start = nums.length;
        num = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] <= num) {
                num = nums[j];
            } else {
                start = j;
            }
        }
        if (start == nums.length) {
            return 0;
        }
        return end - start + 1;

    }
}
