class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] result = new int[26];
        int c = 0;

        for(int i = 0; i < s.length(); i++) {
            result[(int) s.charAt(i) - 'a']++;
        }

        for(int n : result) {
            c += (n % 2 == 0) ? 0 : 1;
        }

        return c <= 1;
    }
}