class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        int i = 0;
        String[] words = s.split(" ");

        if(pattern.length() != words.length) {
            return false;
        }

        for(char c: pattern.toCharArray()) {
            if(!map.containsKey(c) && !map.containsValue(words[i])) {
                map.put(c, words[i]);
            } else if(map.containsKey(c) && map.get(c).equals(words[i])) {
                i++;
                continue;
            } else {
                return false;
            }
            i++;
        }       

        return true;
    }
}