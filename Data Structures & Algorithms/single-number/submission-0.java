class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> res = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!res.containsKey(nums[i])){
                res.put(nums[i],1);
            }else{
                res.put(nums[i],res.get(nums[i])+1);
            }
        }
        for(int key : res.keySet()){
            if(res.get(key)== 1){
                return key;
            }
        }
        return -1;
    }
}
