class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> mapFrecuency = new HashMap<>();
        HashMap<Integer, List<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        /*
         * PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) ->
         * Integer.compare(b,a);
         * );
         */

        for (String w : words) {
            mapFrecuency.put(w, mapFrecuency.getOrDefault(w, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : mapFrecuency.entrySet()) {

            if (!map.containsKey(entry.getValue())) {
                map.put(entry.getValue(), new ArrayList<>());
            }

            map.get(entry.getValue()).add(entry.getKey());
        }

        List<Integer> keys = new ArrayList<Integer>(map.keySet());
        Collections.sort(keys, Collections.reverseOrder());

        while (result.size() < k) {
            int key = keys.remove(0);
            Collections.sort(map.get(key));
            List<String> wl = map.get(key);
            
            result.addAll(wl);
        }

        while (result.size() > k) {
            result.remove(result.size() - 1);
        }

        return result;
    }
}