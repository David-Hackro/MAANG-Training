class Solution {
    public int[][] kClosest(int[][] points, int k) {
        HashMap<Integer, Double> map = new HashMap<>();
        int j = 0;
        int[][] result = new int[k][2];

        for (int[] p : points) {
            double euclideanDistance = (p[0] * p[0]) + (p[1] * p[1]);
            map.put(j, euclideanDistance);
            j++;
        }

        // PriorityQueue minHeap using Euclidean distance

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(
                (n1, n2) -> Double.compare(map.get(n1), map.get(n2)));

        for (int i = 0; i < points.length; i++) {
            minHeap.add(i);
        }

        int x = 0;

        while (!minHeap.isEmpty()) {
            int pos = minHeap.remove();

            if (x < k) {
                result[x] = points[pos];
                x++;
            }

        }

        return result;
    }
}