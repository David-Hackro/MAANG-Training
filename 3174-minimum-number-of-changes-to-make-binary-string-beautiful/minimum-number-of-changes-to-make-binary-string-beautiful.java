class Solution {
    public int minChanges(String s) {
        int result = 0;
        
        for(int i = 1; i < s.length(); i+=2) {
            result += s.charAt(i) == s.charAt(i-1)?0:1;
        }        

        return result;
    }
}