class Solution {
    public String kthDistinct(String[] arr, int k) {
      Map<String, Integer> map = new LinkedHashMap<>();   
      int counter = 0;

      for(String s: arr) {
         map.put(s, map.getOrDefault(s, 0) + 1);
      }

      for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
               ++counter;
               if(counter == k) {
                  return entry.getKey();
               }
            }
      }

      return "";
    }
}