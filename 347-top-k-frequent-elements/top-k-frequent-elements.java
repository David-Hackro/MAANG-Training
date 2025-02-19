class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a,b) -> map.get(b).compareTo(map.get(a))
        );

        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(Integer key: map.keySet()) {
            maxHeap.add(key);
        }

        for(; k > 0; k--) {
            result[index++] = maxHeap.remove();
        }

        return result;
    }
}