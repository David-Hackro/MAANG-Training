class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] result = new char[s.length() + spaces.length];
        int i = 0; 
        int j = 0;

        for (int index = 0; index < s.length(); index++) {

            if (i < spaces.length && spaces[i] == index) {
                result[j++] = ' ';
                i++;
            }

            result[j++] = s.charAt(index);
        }

        return new String(result);
    }
}