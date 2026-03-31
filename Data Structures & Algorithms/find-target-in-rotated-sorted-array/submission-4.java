class Solution {
    public int search(int[] nums, int target) {
        int start = nums[0];
        int end = nums[nums.length-1];
        int i = 0;
        int j = nums.length-1;
        while(i <= j){
            int mid = (i+j)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[i] <= nums[mid]){
                if(nums[i] <= target && target <= nums[mid]){
                    j =  mid - 1;
                }else{
                    i = mid + 1;
                }
            }else{
                if(nums[j] >= target && nums[mid] <= target){
                    i = mid+1;
                }else{
                    j = mid-1;
                }
            }

        }
        return -1;
    }
}
