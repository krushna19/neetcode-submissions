class Solution {
    public boolean hasDuplicate(int[] nums) {
        // for(int i = 0; i < nums.length; i++){
        //     int count = 0;
        //     for(int j = 0; j < nums.length; j++){
        //         if(nums[i]==nums[j]){
        //             count++;
        //         }
        //     }
        //     if(count > 1){
        //         return true;
        //     }
        // }
        // return false;
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!seen.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}