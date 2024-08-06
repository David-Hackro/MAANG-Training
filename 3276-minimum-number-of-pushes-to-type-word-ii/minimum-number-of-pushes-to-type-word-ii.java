class Solution {
    public int minimumPushes(String word) {
     int result = 0;
     int i = 0;
     HashMap<Character, Integer> map = new HashMap<>();

     for(char c: word.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
     }

     List<Integer> list = new ArrayList<>(map.values());
     Collections.sort(list, Collections.reverseOrder());

     for(int n: list) {
        if(i < 8) {
            result += n;
        } else if(i < 16){
            result += (n * 2);
        } else if(i < 24){
            result += (n * 3);
        } else {
            result += (n * 4);
        }

        i++;
     }

     return result;   
    }
}