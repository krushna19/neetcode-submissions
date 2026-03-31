class Solution {
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
         rows = grid.length;
         cols = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i,j,grid,visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(int row,int col,char[][] grid,boolean[][] visited){
        if(row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || grid[row][col] == '0'){
            return;
        }
        visited[row][col] = true;
        int[][] adjList = {{row+1,col},{row-1,col},{row,col+1},{row,col-1}};
        for(int[] pair : adjList){
            dfs(pair[0],pair[1],grid,visited);
        }
    }
}
