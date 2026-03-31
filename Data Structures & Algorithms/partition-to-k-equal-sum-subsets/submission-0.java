class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum  = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0){
            return false;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        return dfs(nums,k,0,0,visited,sum/k);
    }
    public boolean dfs(int[] nums,int k,int idx,int currSum,boolean[] visited,int target){
        if(k == 1){
            return true;
        }
        if(currSum == target){
            return dfs(nums,k-1,0,0,visited,target);
        }
        for(int i = idx; i < nums.length; i++){
            if(visited[i] || i > idx && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            if(nums[i] + currSum > target){
                break;
            }
            visited[i] = true;
            if(dfs(nums,k,i+1,currSum+nums[i],visited,target)){
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}