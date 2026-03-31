class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(word.charAt(0) == board[i][j]){
                    boolean found = dfs(board,i,j,word,0);
                    if(found){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int r,int c,String word,int wi){
        if(wi == word.length()){
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        if(r < 0 || c < 0 || r >= row || c >= col){
            return false;
        }
        if(board[r][c] == ' ' || board[r][c] != word.charAt(wi)){
            return false;
        }
        char ch = board[r][c];
        board[r][c] = ' ';
        if(dfs(board,r+1,c,word,wi+1)|| dfs(board,r,c+1,word,wi+1) || dfs(board,r-1,c,word,wi+1) || dfs(board,r,c-1,word,wi+1)){
            return true;
        }
        board[r][c] = ch;
        return false;
    }
}
               