class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int turns = 0;
        int monsters = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a, b);
        });

        for (int i = 0; i < dist.length; i++) {
            int residual = dist[i] % speed[i] == 0 ? 0 : 1;
            int turn = (int) (dist[i] / speed[i]) + residual;
            maxHeap.add(turn);
        }

        while (!maxHeap.isEmpty() && maxHeap.peek() > turns) {
            maxHeap.remove();
            monsters++;
            turns++;
        }

        if (monsters != dist.length) {
            return monsters;
        }

        return dist.length;
    }
}