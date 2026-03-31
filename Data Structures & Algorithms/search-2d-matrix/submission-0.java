class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int n = matrix.length;
        // int m = matrix[0].length;
        // int i = 0;
        // int j = n;
        // while(i <= n){

        // }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}
