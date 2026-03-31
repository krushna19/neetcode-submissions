class Solution {
    public int longestConsecutive(int[] nums) {
       if (nums == null || nums.length == 0) return 0;
       Arrays.sort(nums);
       int maxcount = 1;
       int count = 1;
       for(int i = 0; i < nums.length-1; i++){
          
          if(nums[i+1] == nums[i]+1){
            count++;
          }else if(nums[i+1] == nums[i]){
            
          }else{
            count = 1;
          }
          maxcount = Math.max(count,maxcount);
       }
       return maxcount; 
    }
}
