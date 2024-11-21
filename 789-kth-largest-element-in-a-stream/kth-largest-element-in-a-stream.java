class KthLargest {

    PriorityQueue<Integer> minHeap;
    int max;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        max = k;
        for (int n : nums) {
            minHeap.add(n);
        }
    }

    public int add(int val) {
        minHeap.add(val);

        while (minHeap.size() > max) {
            minHeap.remove();
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */