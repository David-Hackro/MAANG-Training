class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> map = new HashSet<>();
        StringBuilder sb;
        String[] letters = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for(String word : words) {
            sb = new StringBuilder();

            for(char c : word.toCharArray()) {
                sb.append(letters[(int) c - 'a']);
            }

            map.add(sb.toString());
        }

        return map.size();
    }
}