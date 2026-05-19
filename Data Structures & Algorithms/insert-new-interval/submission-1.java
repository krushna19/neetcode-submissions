class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr = new int[intervals.length+1][2];
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < 2; j++){
                arr[i][j] = intervals[i][j];
            }
        }
        arr[arr.length-1][0] = newInterval[0];
        arr[arr.length-1][1] = newInterval[1];
        Arrays.sort(arr,(a,b) -> a[0] - b[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        int start = arr[0][0];
        int end = arr[0][1];
        for(int i = 1; i < arr.length; i++){
           if(arr[i][0] <= end){
             end = Math.max(end,arr[i][1]);
           }else{
             ans.add(new int[]{start,end});
             start = arr[i][0];
             end = arr[i][1];
           }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}
