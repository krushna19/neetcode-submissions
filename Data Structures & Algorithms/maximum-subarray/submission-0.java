class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int curr_sum  = 0;
            for(int j = i; j < nums.length; j++){
                curr_sum += nums[j];
                if(curr_sum > sum){
                    sum = curr_sum;
                }
            }
        }
        return sum;
    }
}
