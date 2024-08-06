class Solution {
    public int minimumPushes(String word) {
        int result = 0;
        int[] count = new int[26];

        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        Arrays.sort(count);

        for (int i = 25, j = 0; i >= 0; i--, j++) {
            if (j < 8) {
                result += count[i];
            } else if (j < 16) {
                result += (count[i] * 2);
            } else if (j < 24) {
                result += (count[i] * 3);
            } else {
                result += (count[i] * 4);
            }
        }

        return result;
    }
}
