class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>();
        int result = 0;
        double total = 0;
        double subtotal = 0;

        for(int n: nums) {
            heap.add((n + 0.0 ) * -1);

            total += n;
        }

        subtotal = total;

        while(!heap.isEmpty() && subtotal > (total / 2)) {
            double n = Math.abs(heap.remove() / 2);
            subtotal -= n;
            heap.add(n * -1);
            result++;
        }


        return result;
    }
}