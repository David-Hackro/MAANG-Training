class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] result = new int[26];
        int[] result2 = new int[26];
        int i = 0;

        while(i < Math.max(word1.length(), word2.length())) {
            if(i < word1.length()) {
                result[(int) word1.charAt(i) - 'a']++;
            }

            if(i < word2.length()) {
                result2[(int) word2.charAt(i) - 'a']++;
            }

            i++;
        }

        for(int j = 0; j < result.length; j++) {
            
            if(result[j] > 0 && result2[j] == 0) {
                return false;
            }
        }

        Arrays.sort(result);
        Arrays.sort(result2);


        return Arrays.equals(result, result2);
    }
}