class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String sortedWord = new String(temp);

            if(map.containsKey(sortedWord)) {
                map.get(sortedWord).add(s);
            } else {
                List t = new ArrayList<String>();
                t.add(s);
                map.put(sortedWord, t);
            }
        }

        List<List<String>> result = new ArrayList<>(map.values());

        return result;
    }
}