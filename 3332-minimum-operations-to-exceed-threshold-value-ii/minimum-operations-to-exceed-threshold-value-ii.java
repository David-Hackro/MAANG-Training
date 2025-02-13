class Solution {
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int counter = 0;

        for (int n : nums) {
            minHeap.add(new Long(n));
        }

        while (minHeap.peek() < k) {
            long a = minHeap.remove();
            long b = minHeap.remove();
            long min = Math.min(a, b);
            long max = Math.max(a, b);
            long result = (min * 2) + max;
            minHeap.add(result);
            counter++;
        }

        return counter;
    }
}