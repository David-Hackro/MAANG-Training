class Solution {
    public int findKthLargest(int[] nums, int k) {
        // [4,5,3]

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int result = 0;

        for (int n : nums) {
            minHeap.add(n);

            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }

        return minHeap.remove();
    }
}