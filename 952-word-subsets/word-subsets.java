class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        int[] tempFreq;
        List<String> result = new ArrayList<>();

        for (String s : words2) {
            tempFreq = new int[26];
            for (char c : s.toCharArray()) {
                tempFreq[c - 'a']++;
                maxFreq[c - 'a'] = Math.max(maxFreq[c - 'a'], tempFreq[c - 'a']);
            }
        }

        for (String s : words1) {
            tempFreq = new int[26];
            for (char c : s.toCharArray()) {
                tempFreq[c - 'a']++;
            }

            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (tempFreq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                result.add(s);
            }
        }

        return result;
    }
}
