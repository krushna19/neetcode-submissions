class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int l = 0; 
        int r = arr.length-1;
        while(r-l >= k){
            if(Math.abs(x-arr[l]) <= Math.abs(x-arr[r])){
                r--;
            }else{
                l++;
            }
        }
        for(int i = l; i <= r; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}