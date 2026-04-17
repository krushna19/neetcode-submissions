class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int rob1 = 0;
        int rob2 = 0;
        for(int i = 1; i < nums.length; i++){
            int temp = Math.max(nums[i] + rob1,rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        

        int rob3 = 0;
        int rob4 = 0;
        for(int j = 0; j < nums.length-1; j++){
            int temp = Math.max(nums[j] + rob3,rob4);
            rob3 = rob4;
            rob4 = temp;
        }
        return Math.max(rob2,rob4);
    }
}
