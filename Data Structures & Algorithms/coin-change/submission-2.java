class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // initialize
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;  // like infinity
        }

        dp[0] = 0;

        // same pattern as your "change" code
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {

                dp[i] = Math.min(
                    dp[i],
                    1 + dp[i - coin]
                );
            }
        }

        // if not possible
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
