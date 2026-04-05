class Solution {
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    int m , n;
    public void islandsAndTreasure(int[][] grid) {
         m = grid.length;
         n = grid[0].length;
      
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                 if(grid[i][j] == 0){
                    q.add(new int[]{i, j});
                 }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int[] dir : direction) {
                int r = x + dir[0];
                int c = y + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 2147483647) {
                    grid[r][c] = grid[x][y] + 1;
                    q.add(new int[]{r, c});
                }
            }
        }
    }
}