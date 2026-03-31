class Solution {
    public int subsetXORSum(int[] nums) {
        return findXorTotal(nums,0,0);
    }
    public int findXorTotal(int[] nums,int index,int xor){
        if(index == nums.length) return xor;
        int pick = findXorTotal(nums,index+1,xor ^ nums[index]);
        int noPick = findXorTotal(nums,index+1,xor);
        return pick+noPick;
    }
}