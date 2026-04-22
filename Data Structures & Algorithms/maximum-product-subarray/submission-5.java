class Solution {
    public int maxProduct(int[] nums) {
        int maxHere = nums[0];
        int minHere = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
           int tempMax = maxHere;
           maxHere = Math.max(nums[i],Math.max(nums[i]*maxHere,nums[i]*minHere));
           minHere = Math.min(nums[i],Math.min(nums[i]*tempMax,nums[i]*minHere));
           result = Math.max(maxHere,result);
        }
        
        return result;
    }
}
