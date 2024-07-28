class Solution {
    public long getDescentPeriods(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        long ans = 0;

        for(int i = 0; i < prices.length; i++){

            if(!stack.isEmpty() && (prices[i] >= prices[stack.peek()] || Math.abs(prices[i] - prices[stack.peek()]) > 1)) {
                while(!stack.isEmpty()) {
                ans += i - stack.pop();
                }
            }

            stack.push(i);
        }        

        while(!stack.isEmpty()) {
            ans += prices.length - stack.pop();
        }

        return ans;
    }
}