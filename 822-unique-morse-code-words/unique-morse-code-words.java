class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<String, Boolean> map = new HashMap<>();
        StringBuilder sb;
        String[] letters = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for(String word : words) {
            sb = new StringBuilder();

            for(char c : word.toCharArray()) {
                sb.append(letters[(int) c - 'a']);
            }

            map.put(sb.toString(), true);
        }

        return map.size();
    }
}