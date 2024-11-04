class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        right.add(num);
        left.add(right.remove());

        if(left.size() > right.size()) {
            right.add(left.remove());
        }
    }

    public double findMedian() {
      if(right.size() > left.size()) {
            return right.peek();
       }

       return (left.peek() + right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
