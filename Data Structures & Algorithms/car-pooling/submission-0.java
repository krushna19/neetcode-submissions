class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
       List<int[]> points = new ArrayList<>();
       for(int[] trip : trips){
           int passenger = trip[0];
           int start = trip[1];
           int end = trip[2];
           points.add(new int[]{start,passenger});
           points.add(new int[]{end,-passenger});
       }
       points.sort((a,b) -> a[0] == b[0] ? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));
       int currPass = 0;
       for(int[] point : points){
          currPass += point[1];
          if(currPass > capacity){
             return false;
          }
       }
       return true;
    }
}