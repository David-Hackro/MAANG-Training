class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> seen = new HashSet<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        if (n == 1 && source == destination) {
            return true;
        }

        for (int[] a : edges) {
            int x = a[0];
            int y = a[1];

            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(y);

            map.putIfAbsent(y, new ArrayList<>());
            map.get(y).add(x);
        }

        return dfs(source, destination);
    }

    private boolean dfs(int source, int destination) {

        for (int n : map.get(source)) {

            if (!seen.contains(n)) {
                seen.add(n);

                if (n == destination) {
                    return true;
                }

                if (dfs(n, destination)) {
                    return true;
                }

            }
        }

        return false;
    }
}