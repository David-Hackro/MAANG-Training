class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int counter = 0;
        int max = 0;
        int l = 0;

        for(int r = 0; r < s.length(); r++) {
            counter += Math.abs((int)(s.charAt(r)) - ((int)t.charAt(r))); 

            while(counter > maxCost) {
                counter -= Math.abs(((int)s.charAt(l)) - ((int)t.charAt(l)));
                l++;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}