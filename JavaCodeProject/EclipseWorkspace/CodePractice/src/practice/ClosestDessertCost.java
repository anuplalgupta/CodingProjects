package practice;

public class ClosestDessertCost {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        boolean[] dp = new boolean[target+1];

        dp[0] = true;
        for(int i =1;i<=target;i++){
            for(int t : toppingCosts){
                if(i-t>=0 && dp[i-t]){
                    dp[i] = true;
                    break;
                }
            }
        }
        int res = baseCosts[0];

        for(int b : baseCosts){
            if(b>target){
                res = Math.abs(target - res) > Math.abs(target - b) ? b : res;
            }

            int diff = target - b;

            for(int i = diff;i>=0;i--){
                if(dp[i]){
                    res = Math.abs(target- (b+i)) < Math.abs(target - res) ? b+i : res;
                    break;
                }
            }
        }

        return res;

    }
}
