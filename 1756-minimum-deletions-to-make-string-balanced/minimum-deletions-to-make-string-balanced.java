class Solution {
    public int minimumDeletions(String s) {
        int a = 0;
        int b = 0;
        int min = s.length();
        int[] results = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            a+= s.charAt(s.length() -1 - i)=='a'?1:0;
            b+= s.charAt(i)=='b'?1:0;

            results[s.length() -1 - i] += a;
            results[i] += b;
        }       

        for(int n : results) {
            min = Math.min(min, n);
        }

        return min -1;
    }
}