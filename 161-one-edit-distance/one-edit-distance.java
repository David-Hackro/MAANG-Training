class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        
        if(Math.abs(ls - lt) > 1 || s.equals(t)) {
            return false;
        }

        for(int i = 0; i < Math.max(ls, lt); i++) {
            
            if(i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i)) {
                continue;
            }

            if(ls < lt){
                return s.substring(i).equals(t.substring(i+1));
            } else if(ls > lt) {
                return s.substring(i +1).equals(t.substring(i));
            } else {
                return s.substring(i + 1).equals(t.substring(i +1));
            }

        }

        return true;
    }
}