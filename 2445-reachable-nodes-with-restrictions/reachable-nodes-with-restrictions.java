class Solution {
    int counter = 0;
    HashSet<Integer> seen = new HashSet<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        for(int node: restricted) {
            seen.add(node);
        }

        for(int[] a: edges) {
            int x = a[0];
            int y = a[1];

            if(!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }

            if(!map.containsKey(y)) {
                map.put(y, new ArrayList<>());
            }

            map.get(x).add(y);
            map.get(y).add(x);
        }

        if(!seen.contains(0)) {
            counter++;
            dfs(0);
        }

        return counter;
    }


    private void dfs(int node) {
        seen.add(node);

        for(int n: map.getOrDefault(node, new ArrayList<>())) {
            if(!seen.contains(n)) {
                counter++;
                dfs(n);
            }
        }
    }
}