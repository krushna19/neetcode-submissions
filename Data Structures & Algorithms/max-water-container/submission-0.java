class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxa = 0;
        while(i < j){
            int min = 0;
            if(heights[i] < heights[j]){
              min = i;
           }else{
              min = j;
           }
           int cap = (j - i)*heights[min];
           maxa = Integer.max(cap,maxa);
           if(heights[i] < heights[j]){
              i++;
           }else{
            j--;
           }
        }
        return maxa;
    }
}
