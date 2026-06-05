class Solution {
    int[][] dp;
    int[] suffix;
    int n;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[n][n+1];
        suffix = new int[n];
        suffix[n-1] = piles[n-1];
        for(int i = n - 2; i >= 0; i--){
            suffix[i] = piles[i] + suffix[i+1];
        }
        return solve(0,1);
    }
    public int solve(int i, int m){
        if(i >= n){
            return 0;
        }
        if(i + 2*m >= n){
            return suffix[i];
        }
        if(dp[i][m] != 0){
            return dp[i][m];
        }
        int result = 0;
        for(int x = 1; x <= 2*m && i + x <= n; x++){
            int opponent = solve(i+x , Math.max(m,x));
            int current = suffix[i] - opponent;
            result = Math.max(result , current);
        }
        return dp[i][m] = result;
    }
}