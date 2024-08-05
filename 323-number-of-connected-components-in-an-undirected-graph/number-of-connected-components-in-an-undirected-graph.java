class Solution {
   HashMap<Integer, List<Integer>> map = new HashMap<>();
   HashSet<Integer> seen = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
         int counter = 0;
         int max = 0;
         for(int[] a: edges) {
            int x = a[0];
            int y = a[1];
            max = Math.max(max, x);
            max = Math.max(max, y);

            if(!map.containsKey(x)){
               map.put(x, new ArrayList<>());
            }
            
            if(!map.containsKey(y)){
               map.put(y, new ArrayList<>());
            }

            map.get(x).add(y);
            map.get(y).add(x);
         }

         for(int i = 0; i < n; i++) {
            if(!seen.contains(i)) {
               counter++;
               dfs(i);
            }
         }

        return counter;
    }

    private void dfs(int node) {
    seen.add(node);
      for(int n: map.getOrDefault(node, new ArrayList<>())) {
         if(!seen.contains(n)) {
            dfs(n);
         }
      }
    }



}