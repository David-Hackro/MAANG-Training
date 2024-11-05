class Solution {
    
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;

        for(int pile: piles) {
            maxHeap.add(pile + 0.0);
            result += pile;
        }

        while(k > 0) {
            double max = Math.floor(maxHeap.peek() / 2);
            result -= max;
            max = maxHeap.remove() - max;
            if(max > 0) {
                maxHeap.add(max);
            }

            k--;
        }

        return result;
    }
}