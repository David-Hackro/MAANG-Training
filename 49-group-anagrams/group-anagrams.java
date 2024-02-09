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
                map.put(sortedWord, new ArrayList<>(Arrays.asList(s)));
            }
        }

        List<List<String>> result = new ArrayList<>(map.values());

        return result;
    }
}