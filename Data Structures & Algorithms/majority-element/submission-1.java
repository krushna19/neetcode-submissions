class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> ans =  new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(ans.containsKey(nums[i])){
                ans.put(nums[i], ans.get(nums[i]) + 1);
                if(ans.get(nums[i]) > (nums.length/2)){
                   return nums[i];
                }
            }else{
                ans.put(nums[i],1);
            }
            
        }
        return nums[0];
    }
}