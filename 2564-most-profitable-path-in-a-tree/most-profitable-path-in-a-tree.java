class Solution {
    HashMap<Integer, HashSet<Integer>> map;
    HashMap<Integer, Integer> bobStepsMap;
    int max;
    int[] arrayAmount;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        map = new HashMap<>();
        max = Integer.MIN_VALUE;
        bobStepsMap = new HashMap<>();
        arrayAmount = amount;

        for (int[] e : edges) {

            if (!map.containsKey(e[0])) {
                map.put(e[0], new HashSet<>());
            }

            if (!map.containsKey(e[1])) {
                map.put(e[1], new HashSet<>());
            }

            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        map.get(0).add(-1);
        // bob path

        bobStepsMap.put(bob, 1);
        bobPath(bob, -1, 1);
        System.out.println(bobStepsMap);
        dfs(0, -1, 1, 0);

        return max;
    }

    private boolean bobPath(int node, int parent, int steps) {

        if (node == 0) {
            return true;
        }

        for (int n : map.get(node)) {

            if (n != parent) {
                bobStepsMap.put(n, steps +1);

                if (bobPath(n, node, steps + 1)) {
                    return true;
                }

                bobStepsMap.remove(n);
            }
        }

        return false;
    }

    private void dfs(int node, int parent, int steps, int amount) {
        if (bobStepsMap.containsKey(node)) {
            // alice < bob
            if (steps < bobStepsMap.get(node)) {
                amount += arrayAmount[node];
            } else if (steps == bobStepsMap.get(node)) {
                amount = amount + (arrayAmount[node] / 2);
            }
        } else {
            amount += arrayAmount[node];
        }

        for (int n : map.get(node)) {
            if (n != parent) {
                dfs(n, node, steps + 1, amount);
            }
        }

        if(map.get(node).size() == 1){
            max = Math.max(max, amount);
        }

    }

}
