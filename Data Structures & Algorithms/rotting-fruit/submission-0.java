class Solution {
    
    public int orangesRotting(int[][] grid) {
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
       for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){
             if(grid[i][j] == 2){
                 q.add(new int[]{i,j});
             }
          }
       }
       while(!q.isEmpty()){
          int size = q.size();
          boolean rooted = false;
          for(int i = 0; i < size; i++){
          int[] curr = q.poll();
          int x = curr[0];
          int y = curr[1];
           for(int[] dir : direction){
              int r = x+dir[0];
              int c = y+dir[1];
              if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1){
                 grid[r][c] = 2;
                 q.add(new int[]{r,c});
                 rooted = true;
              }
            }
          }
          if(rooted){
            time++;
          } 
       }
       for(int i = 0; i < m; i++){
         for(int j = 0; j < n; j++){
            if(grid[i][j] == 1){
                return -1;
            }
         }
       }
       return time;
    }
}
