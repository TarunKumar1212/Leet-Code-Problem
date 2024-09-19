class Solution {
    public int maxProfit(int[] prices) {
        
        int min = prices[0];
        int profit = 0 ;
        int n = prices.length;
        
        for(int i = 1 ; i < n ; i++)
        {
            int cost = prices[i] - min ;
            profit = Math.max(profit,cost); 
//             cost = 1 - 7 = -6 (ignore since it's negative)
            min = Math.min(prices[i],min) ;
        }
        
        return profit;
    }
}