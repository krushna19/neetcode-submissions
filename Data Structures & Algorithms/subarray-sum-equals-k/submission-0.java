class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int cursum = 0;
        Map<Integer,Integer> sumcountmap = new HashMap<>();
        sumcountmap.put(0,1);
        for(int num : nums){
            cursum += num;
            int req = cursum - k;
            if(sumcountmap.containsKey(req)){
                count += sumcountmap.get(req);
            }
            sumcountmap.put(cursum , sumcountmap.getOrDefault(cursum,0)+1);
        }
        return count;
    }
}