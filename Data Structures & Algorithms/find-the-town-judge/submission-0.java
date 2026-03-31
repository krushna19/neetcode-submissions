class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int out = trust[0][1];
        for(int i = 1; i < trust.length; i++){
            if(trust[i][1] == out){
                continue;
            }else{
                return -1;
            }
        }
        return out;
    }
}