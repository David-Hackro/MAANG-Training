class Solution {
    public int maxVowels(String s, int k) {
        int l = 0;
        int sum = 0;
        int max = 0;
        String vl = "aeiou";
        //"leetcode"
        for(int r = 0; r < s.length(); r++) {
            sum += vl.contains(s.charAt(r)+"")?1:0;

            if((r - l + 1) == k) {
                max = Math.max(max, sum);
                sum -= vl.contains(s.charAt(l)+"")?1:0;
                l++;
            }
        }       

        return max;
    }
}