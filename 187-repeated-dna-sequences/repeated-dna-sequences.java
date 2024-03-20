class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        if(s.length() < 10) {
            return result; 
        }

        for(int i = 9; i < s.length(); i++) {
            map.put(s.substring(i-9, i +1), map.getOrDefault(s.substring(i-9, i +1), 0) + 1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}