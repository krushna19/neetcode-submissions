class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] effort = new int[row][col];
        for(int[] arr : effort){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        effort[0][0] = 0;
        pq.offer(new int[]{0,0,0});
        int[][] direction = {
           {1,0},
           {-1,0},
           {0,1},
           {0,-1}
        };
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currEffort = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(r == row - 1 && c == col - 1){
                return currEffort;
            }
            for(int[] dir : direction){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nc >= 0 && nr < row && nc < col){
                    int diff = Math.abs(heights[nr][nc] - heights[r][c]);
                    int newEffort = Math.max(currEffort,diff);
                    if(newEffort < effort[nr][nc]){
                        effort[nr][nc] = newEffort;
                        pq.offer(new int[]{newEffort,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}