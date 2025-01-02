class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;// index s
        int j = 0;//index t
        
        while(i < s.length() && j < t.length()) {

            if(s.charAt(i) == t.charAt(j)) {
                j++;
            }

            i++;
        }


        return t.length() - j;
    }
}