class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] frecuency = new int[26];
        int[] temp;

        List<String> result = new ArrayList<>();

        for(String s: words2) {
            temp = new int[26];

            for(char c: s.toCharArray()) {
                temp[c - 'a'] ++;

                frecuency[c - 'a'] = Math.max(frecuency[c - 'a'], temp[c - 'a']);
            }
        }


        for(String s: words1) {
            
            temp = new int[26];
            boolean flag = true;
            
            for(char c: s.toCharArray()) {
                temp[c - 'a']++;
            }

            for(int i = 0; i < 26; i++) {
                
                if(temp[i] < frecuency[i]) {
                    flag = false;
                    break;
                }
            }



            if(flag) {
                result.add(s);
            }
        }


        return result;
    }
}