class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }       

        Character ch = null;

        while (!map.isEmpty()) {
            int max = 0;

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                
                if(entry.getValue() > max) {
                    max = entry.getValue();
                    ch = entry.getKey();
                }
            }

            map.remove(ch);

            for(int i = 0; i < max; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}