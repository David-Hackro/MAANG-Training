class Solution {
    public String greatestLetter(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        for(int i = 0; i < s.length(); i++) {
            if(Character.isLowerCase(s.charAt(i))) {
                lower[s.charAt(i) - 'a']++;
            } else{
                upper[s.charAt(i) - 'A']++;
            }
        }

        for(int i = 25; i >= 0; i--) {
            if(lower[i] > 0 && upper[i] > 0) {
                char letter = (char) (i + 'A');

                return letter + "";
            }
        }

        return "";
    }
}