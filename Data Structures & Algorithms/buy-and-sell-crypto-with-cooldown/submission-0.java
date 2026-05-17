class Solution {
    public int maxProfit(int[] prices) {
       int hold = -prices[0];
       int sold = 0;
       int rest = 0;
       for(int i = 1; i < prices.length; i++){
         int pre_hold = hold;
         int pre_sold = sold;
         int pre_rest = rest;
         hold = Math.max(pre_hold,pre_rest - prices[i]);
         sold = pre_hold + prices[i];
         rest = Math.max(pre_rest,pre_sold);
       }
       return Math.max(sold,rest);
    }
}
