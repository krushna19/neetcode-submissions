class Solution {
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int maxArea = 0;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int curr = dfs(i,j,grid,visited);
                    if(curr > maxArea){
                        maxArea = curr;
                    }
                }
            }
        }
        return maxArea;
    }
    public int dfs(int row,int col,int[][] grid, boolean[][] visited){
        
        if(row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || grid[row][col] == 0){
            return 0;
        }
        int area = 1;
        visited[row][col] = true;
        area += dfs(row+1,col,grid,visited);
        area += dfs(row-1,col,grid,visited);
        area += dfs(row,col+1,grid,visited);
        area += dfs(row,col-1,grid,visited);
        return area;
    }
}
