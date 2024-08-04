class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
         HashSet<Integer> seen = new HashSet<>();
         HashSet<Integer> result = new HashSet<>();

         for(List<Integer> l: edges) {
            int x = l.get(0);
            int y = l.get(1);

            if(!seen.contains(x)) {
               result.add(x);
            }

            seen.add(y);
            result.remove(y);
         }
         
       return new ArrayList<>(result); 
    }
}