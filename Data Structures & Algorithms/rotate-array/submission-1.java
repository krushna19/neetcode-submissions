class Solution {
    public void rotate(int[] nums, int k) {
        int s = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,s-1);
        reverse(nums,s,nums.length-1);
    }
    public void reverse(int[] nums, int a, int b){
        while( a < b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }
    }
}