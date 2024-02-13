class Solution {
    public String customSortString(String order, String s) {
        
        int[] letters = new int[26];
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            letters[((int)(c - 'a'))]++;
        }

        for(char c : order.toCharArray()) {
            
            for(int j =0; j < letters[((int) (c - 'a'))]; j++) {
                sb.append(c);
            }

            if(letters[((int) (c - 'a'))] > 0) {
                letters[((int) (c - 'a'))] = 0;
            }

        }

        for(int i = 0; i < letters.length; i++) {
                
            for(int j =0; j < letters[i]; j++) {
                sb.append(((char) (i + 97)));
            }
        }

        return sb.toString();
    }
}