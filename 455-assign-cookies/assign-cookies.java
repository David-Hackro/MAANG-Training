class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0;
        int j = 0;
        int child = 0;
        int cookie = 0;
        int result = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        while (i < g.length && j < s.length) {

            child = g[i];
            cookie = s[j];

            if (child <= cookie) {
                result++;
                i++;
            }

            j++;
        }

        return result;
    }
}