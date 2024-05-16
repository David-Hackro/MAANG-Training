class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int r = 0;
        int size = t.length();
        int min = Integer.MAX_VALUE;
        int counter = 0;
        int x = 0;

        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);

            counter += map.get(s.charAt(i))>=0?1:0;

            while(counter == size && x <= i) {
                map.put(s.charAt(x), map.get(s.charAt(x)) + 1);
                counter -= map.get(s.charAt(x))>0?1:0;

                if(min > i - x +1) {
                    min = i - x + 1;
                    r = x;
                }
                x++;
            }
        }

        if(min == Integer.MAX_VALUE){
            min = 0;
        }

        return s.substring(r, r + min);
    }
}