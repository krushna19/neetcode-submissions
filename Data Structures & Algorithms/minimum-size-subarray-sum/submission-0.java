class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int minsubarrl = Integer.MAX_VALUE;
        int sum  = 0;
        for(int right = 0; right < n; right++){
           sum += nums[right];
           while(sum >= target){
              minsubarrl = Math.min(minsubarrl,right-left+1);
              sum -= nums[left];
              left++;
           }
        }
        if(minsubarrl == Integer.MAX_VALUE){
            return 0;
        }
        return minsubarrl;
    }
}