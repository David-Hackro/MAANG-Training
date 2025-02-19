class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //key (index == freq) - list with the numbers
        HashMap<Integer, HashSet<Integer>> indices = new HashMap<>();

        for(int n: nums) {
            //1:1

            //[0,2]
            map.put(n, map.getOrDefault(n, 0) + 1);

            //array in the indice (freq) = number(key)
            
            if(!indices.containsKey(map.get(n))) {
                indices.put(map.get(n), new HashSet<Integer>());
            }

            indices.get(map.get(n)).add(n);
        }
        HashSet<Integer> set = new HashSet<>();

        //map = 3
        for(int i = indices.size(); i > 0 && index <= k; i--) {
            
            for(int n: indices.get(i)) {
                if(!set.contains(n) && index < k) {
                    result[index++] = n;
                }

                set.add(n);
            }
        }
        
        return result;
    }
}