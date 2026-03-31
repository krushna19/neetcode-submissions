class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n =  nums.length/3;
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int i = 0;  i < nums.length; i++){
            res.put(nums[i],res.getOrDefault(nums[i],0)+1);
        }
        List<Integer> result =  new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : res.entrySet()){
            if(e.getValue() > n){
                result.add(e.getKey());
            }
        }
        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            ans[i] = result.get(i);
        }
        return result;
    }
}