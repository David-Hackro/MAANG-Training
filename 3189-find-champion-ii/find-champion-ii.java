class Solution {
    HashSet<Integer> nodes;
    HashSet<Integer> seen;
    HashMap<Integer, List<Integer>> map;

    public int findChampion(int n, int[][] edges) {
        nodes = new HashSet<>();
        seen = new HashSet<>();
        map = new HashMap<>();

        for (int node = 0; node < n; node++) {        
            nodes.add(node);
        }    

        if (edges.length == 0 && n <= 1) {
            return 0;
        }

        for (int[] array : edges) {
            int nodeA = array[0];
            int nodeB = array[1];

            if (!map.containsKey(nodeA)) {
                map.put(nodeA, new ArrayList<>());
            }

            map.get(nodeA).add(nodeB);
        }

        for (int node = 0; node < n; node++) {

            if (!seen.contains(node)) {
                dfs(node);
            }
        }

        if (Math.abs(seen.size() - nodes.size()) != 1) {
            return -1;
        }

        for (int s : seen) {
            nodes.remove(s);
        }

        return nodes.iterator().next();
    }

    private void dfs(int node) {
        for (int n : map.getOrDefault(node, new ArrayList<>())) {
            if (!seen.contains(n)) {
                seen.add(n);
                dfs(n);
            }
        }
    }
}