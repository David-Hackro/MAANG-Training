class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        HashMap<Character, Integer> temp;
        List<String> result = new ArrayList<>();

        for(String s: words2) {
            temp = new HashMap<>();

            for(char c: s.toCharArray()) {
                temp.put(c, temp.getOrDefault(c, 0) + 1);

                if(!map.containsKey(c)) {
                    map.put(c, 1);
                } else if(map.get(c) < temp.get(c)) {
                    map.put(c, temp.get(c));
                }
            }
        }


        for(String s: words1) {
            temp = new HashMap<>();
            map2 = new HashMap<>(map);

             
            for(char c: s.toCharArray()) {
                temp.put(c, temp.getOrDefault(c, 0) + 1);

                if(map2.containsKey(c) && map2.get(c) <= temp.get(c)) {
                    map2.remove(c);
                }
            }

            if(map2.isEmpty()) {
                result.add(s);
            }
        }


        return result;
    }
}