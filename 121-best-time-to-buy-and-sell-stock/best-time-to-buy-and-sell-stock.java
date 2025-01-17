class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }
        
        int higher = prices[prices.length -1];
        int max = 0;

        for(int i = prices.length -2; i >= 0; i--) {
            higher = Math.max(prices[i + 1], higher);
            max = Math.max(max, higher - prices[i]);
        }

        return max;
    }
}