class Solution {
    public int longestConsecutive(int[] nums) {
       if (nums == null || nums.length == 0) return 0;
       HashSet<Integer> set = new HashSet<>();
       for(int i = 0; i < nums.length; i++){
          set.add(nums[i]);
       }
       int longest = 0;
       for(int x : set){
        if(!set.contains(x-1)){
            int cur = x;
            int len = 1;
            while(set.contains(cur+1)){
               cur++;
               len++;
            }
            longest = Math.max(longest,len);
        }
       }
       return longest;
    }
}
