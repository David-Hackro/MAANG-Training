class Solution {
    HashMap<Integer, ArrayList<Integer>> map;
    HashSet<Integer> seen;

    public boolean validTree(int n, int[][] edges) {
        map = new HashMap<>();
        seen = new HashSet<>();

        if (edges.length != n - 1) return false;


        for (int[] array : edges) {

            if (!map.containsKey(array[0])) {
                map.put(array[0], new ArrayList<>());
            }

            if (!map.containsKey(array[1])) {
                map.put(array[1], new ArrayList<>());
            }

            map.get(array[0]).add(array[1]);
            map.get(array[1]).add(array[0]);
        }

        dfs(0);

        return seen.size() == n;
    }
    // Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]

    private void dfs(int node) {

        if (seen.contains(node))
            return;
        seen.add(node);

        for (int n : map.getOrDefault(node, new ArrayList<>())) {
            dfs(n);
        }
    }
}