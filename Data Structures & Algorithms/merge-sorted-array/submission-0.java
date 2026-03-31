class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans =  new int[m+n];
        int a  = 0;
        int b = 0;
        int i = 0;
        
            while(a < m && b < n){
                if(nums1[a] <= nums2[b]){
                    ans[i] = nums1[a];
                    a++;
                    i++;
                }else{
                    ans[i] = nums2[b];
                    b++;
                    i++;
                }
            }
            
            
        while (a < m) {
            ans[i++] = nums1[a++];
        }
        while (b < n) {
            ans[i++] = nums2[b++];
        }

        
        for (int t = 0; t < m + n; t++) {
            nums1[t] = ans[t];
        }

    }
}