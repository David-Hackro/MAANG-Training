class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }
        int[] copy = new int[prices.length];
    
        copy[copy.length -2] = prices[prices.length -1];
        int max = 0;

        for(int i = copy.length -2; i >= 0; i--) {
            copy[i] = Math.max(prices[i + 1], copy[i + 1]);
            max = Math.max(max, copy[i] - prices[i]);
        }

        return max;
    }
}