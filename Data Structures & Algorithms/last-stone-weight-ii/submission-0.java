class Solution {
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for(int stone : stones){
            stoneSum += stone;
        }
        int target =stoneSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int w : stones){
            for(int j = target; j >= w; j--){
                dp[j] = dp[j] || dp[j - w];
            }
        }
        for(int j = target; j >= 0; j--){
            if(dp[j]){
                return stoneSum - 2 * j;
            }
        }
        return 0;
    }
}