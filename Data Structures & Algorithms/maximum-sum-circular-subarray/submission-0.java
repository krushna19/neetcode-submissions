class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int gM = nums[0];
       int gm = nums[0];
       int total = 0;
       int currM = 0;
       int currm = 0;
       for(int num : nums){
           currM = Math.max(currM + num,num);
           currm = Math.min(currm + num,num);
           total += num;
           gM = Math.max(currM,gM);
           gm = Math.min(currm,gm);
       } 
       if(gM > 0){
           return Math.max(gM,total - gm);
       }else{
           return gM;
       }
    }
}