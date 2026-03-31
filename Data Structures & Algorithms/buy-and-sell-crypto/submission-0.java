class Solution {
    public int maxProfit(int[] prices) {
        int maxpro = 0;
        int s = 0;
        int i = 1;
        while(i < prices.length){
            if(prices[i] < prices[s]){
                s = i;
            }
            maxpro = Math.max(maxpro,prices[i] - prices[s]);
            i++;
        }
        return maxpro;
    }
}
