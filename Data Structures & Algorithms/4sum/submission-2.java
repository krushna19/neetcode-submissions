class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
               int p = j+1;
               int q = nums.length-1;
               while(p < q){
                 long sum =(long)nums[i]+nums[j]+nums[p]+nums[q];
                 if(sum == target){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[p],nums[q]));
                    p++;
                    q--;
                 }else if(sum < target){
                    p++;
                 }else{
                    q--;
                 }
               }
            }
           
        }
         return new ArrayList<>(ans);
    }
}