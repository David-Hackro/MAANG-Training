class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int turns = 0;
        int monsters = 0;

        // by potential danger
        // PriorityQueue<Map.Entry<Integer, Integer>>
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.getValue(), b.getValue());
        });


       for (int i = 0; i < dist.length; i++) {
            int residual = dist[i] % speed[i] ==0?0:1;
            int turn = (int) (dist[i] / speed[i]) +  residual;

            map.put(i, turn);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }


        while (!maxHeap.isEmpty() && maxHeap.peek().getValue() > turns) {
            Map.Entry<Integer, Integer> monster = maxHeap.remove();
            monsters++;
            turns++;
        }

        if (monsters != dist.length) {
            return monsters;
        }

        return dist.length;
    }
}