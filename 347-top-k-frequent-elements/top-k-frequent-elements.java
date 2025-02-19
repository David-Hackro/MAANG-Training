class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //key (index == freq) - list with the numbers
        HashMap<Integer, HashSet<Integer>> indices = new HashMap<>();
        

        //nums = [1,2]
        //k    = 2
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
        HashSet<Integer> uniques = new HashSet<>();
        List<Integer> keys = new ArrayList<>(indices.keySet());
        Collections.sort(keys);


        for(int j = keys.size() -1; j >= 0 && index < k; j--) {
            
            for(int m : indices.get(keys.get(j))) {
                if(index < k && !uniques.contains(m)) {
                    result[index++] = m;
                }

                uniques.add(m);
            }
        }

        return result;
    }
}