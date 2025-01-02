class Solution {
    public int partitionString(String s) {
       //abacaba
        int[] letters = new int[26];
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            
            if(letters[s.charAt(i) - 'a'] != 0) {                
                result++;
                letters = new int[26];
            }

            letters[s.charAt(i) - 'a']++;
        }

        return ++result;
    }
}