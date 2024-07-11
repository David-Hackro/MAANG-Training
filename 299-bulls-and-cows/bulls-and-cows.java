class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;  
        StringBuilder result = new StringBuilder();    
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapg = new HashMap<>();
        char s = ' ';
        char g = ' ';

        for(int i = 0; i < secret.length(); i++) {
            s = secret.charAt(i);
            g = guess.charAt(i);

            if(s == g) {
                bulls++;
            } else {
                maps.put(s, maps.getOrDefault(s, 0) + 1);
                mapg.put(g, mapg.getOrDefault(g, 0) + 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : maps.entrySet()) {
            
            if(mapg.containsKey(entry.getKey())) {
                cows+= Math.min(mapg.get(entry.getKey()), entry.getValue());
            }

        }

        result.append(bulls);
        result.append("A");
        result.append(cows);
        result.append("B");

        return result.toString();

    }
}