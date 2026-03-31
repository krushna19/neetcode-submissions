class Solution {
    public int findMin(int[] nums) {
        int start = nums[0];
        int end = nums[nums.length - 1];
        int i = 0;
        int j = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(i <= j){
            int mid  = (i+j)/2;
            if(nums[mid] < min){
                min = nums[mid];
            }
            if(nums[mid] > end){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return min;
    }
}
