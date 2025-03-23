class WordDistance {
    // [["practice", "makes", "perfect", "coding", "makes"]]

    HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();

        for (int i = 0; i < wordsDict.length; i++) {
            if (!map.containsKey(wordsDict[i])) {
                map.put(wordsDict[i], new ArrayList<>());
            }

            map.get(wordsDict[i]).add(i);
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            Collections.sort(map.get(entry.getKey()));
        }
    }

    public int shortest(String word1, String word2) {
        // sort increase
        List<Integer> listA = map.get(word1);
        List<Integer> listB = map.get(word2);
        // performe the op meanwhile n <= target
        int min = Integer.MAX_VALUE;

        for (Integer index : listA) {
            min = Math.min(min, getClosestElement(index, listB));
        }

        return min;
    }

    private int getClosestElement(int index, List<Integer> list) {
        int l = 0;
        int r = list.size() -1;
        int min = Integer.MAX_VALUE;

        while (l <= r) {
            int m = (l + r) / 2;
            // 2,6,7,11,66
            // 9
            // 7 <= 9
            if (list.get(m) <= index) {
                min = Math.min(min, index - list.get(m));
                l = m + 1;
            } else {
                min = Math.min(min, list.get(m) - index);
                r = m - 1;
            }
        }

        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */