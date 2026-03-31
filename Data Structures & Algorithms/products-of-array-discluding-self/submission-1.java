class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1, zeroCount = 0;
        int[] result =  new int[nums.length];
        for(int num : nums){
            if(num != 0){
                prod *= num;
            } else {
                zeroCount++;
            }
        }
        if(zeroCount > 1){
            return new int[nums.length];
        }
        for(int i = 0; i < nums.length; i++){
           if(zeroCount > 0){
             if(nums[i] == 0){
                result[i] = prod;
             }else{
                result[i] = 0;
             }
           }else{
            result[i] = prod / nums[i];
           }
        }
        return result;
    }
}  
