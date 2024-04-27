class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Create a HashMap to map characters from string 's' to characters from string 't'
        HashMap<Character, Character> map = new HashMap<>();

        // Iterate through the characters of strings 's' and 't'
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i); // Current character in string 's'
            char b = t.charAt(i); // Current character in string 't'

            // If character 'a' is not mapped to any character in 't' and vice versa
            if(!map.containsKey(a) && !map.containsValue(b)) {
                map.put(a, b); // Map 'a' to 'b'
            } 
            // If 'a' is mapped to 'b', continue with the next pair of characters
            else if (map.containsKey(a) && map.get(a) == b) {
                continue;
            } 
            // If 'a' is mapped to another character than 'b' or 'a' is not mapped but 'b' is already mapped to another character
            else {
                return false; // The strings are not isomorphic
            }
        }

        // If we reach here, it means all mappings are valid, so the strings are isomorphic
        return true;       
    }
}
