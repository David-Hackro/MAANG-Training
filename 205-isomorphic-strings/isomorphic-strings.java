class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(!map.containsKey(a) && !map.containsValue(b)) {
                map.put(a, b);
            } else if (map.containsKey(a) && map.get(a) == b) {
                continue;
            } else {
                return false;
            }
        }


        return true;       
    }
}