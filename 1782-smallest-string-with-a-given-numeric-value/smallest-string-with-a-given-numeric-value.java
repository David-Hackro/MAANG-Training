class Solution {
    public String getSmallestString(int n, int k) {
        char[] word = new char[n];
        int i = n - 1;

        // execute meanwhile k > 0
        // k = 4
        // n = 3
        k = k - n;
        while (k > 0) {
            int res = Math.min(k, 25);
            char letter = (char) (res + 'a');
            word[i] = letter;
            k-=res;
            i--;
        }

        //
        for (; i >= 0; i--) {
            word[i] = 'a';
        }

        return new String(word);
    }
}