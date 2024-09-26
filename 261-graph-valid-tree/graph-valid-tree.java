class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

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

        queue.add(0);

        while (!queue.isEmpty()) {
            int node = queue.remove();

            if (seen.contains(node)) {
                return false;
            }

            seen.add(node);// 0,1,2,3

            for (int x : map.getOrDefault(node, new ArrayList<>())) {

                if (!seen.contains(x)) {
                    queue.add(x);;
                }
            }

        }

        return seen.size() == n;
    }
}