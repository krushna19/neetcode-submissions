class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1];
        HashMap<Integer,Integer> counter = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // if(counter.containsKey(nums[i])){
            //     counter.put(nums[i],counter.get(nums[i])+1);
            // }
            // else{
            //     counter.put(nums[i],1);
            // }
            counter.put(nums[i],counter.getOrDefault(nums[i],0)+1);
        }
        for(int key : counter.keySet()){
            int freq = counter.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] res = new int[k];
        int cou = 0;

        for(int pos = bucket.length-1; pos >=0 && cou < k; pos--){
            if(bucket[pos] != null){
                for(Integer integer : bucket[pos]){
                  res[cou++] = integer;
                }
            }
        }
        return res;
    }
}
