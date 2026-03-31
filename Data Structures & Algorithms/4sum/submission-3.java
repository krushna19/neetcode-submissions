class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1; j < nums.length;){
               int p = j+1;
               int q = nums.length-1;
               while(p < q){
                 long sum =(long)nums[i]+nums[j]+nums[p]+nums[q];
                 if(sum == target){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[p],nums[q]));
                    p++;
                    q--;
                    while(p < q && nums[p] == nums[p-1]){
                        p++;
                    }
                 }else if(sum < target){
                    p++;
                 }else{
                    q--;
                 }
               }
               j++;
               while(j < nums.length && nums[j] == nums[j-1]){
                j++;
               }
            }
           
        }
         return new ArrayList<>(ans);
    }
}