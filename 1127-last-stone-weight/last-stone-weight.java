class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int result = 0;


        for(int stone: stones) {
            heap.add(stone * -1);
        }

        while(heap.size() > 1) {
            int stoneOne = heap.remove();
            int stoneTwo = heap.remove(); 

            if(stoneOne != stoneTwo) {
                int newStone = Math.abs(stoneOne - stoneTwo);
                heap.add(newStone * -1);
            }
        }

        return heap.isEmpty()?0:Math.abs(heap.peek());
    }
}