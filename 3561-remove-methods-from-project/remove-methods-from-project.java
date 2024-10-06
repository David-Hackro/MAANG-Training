class Solution {
    HashMap<Integer, List<Integer>> map;
    HashSet<Integer> suspicious;
    HashSet<Integer> seen;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        map = new HashMap<>();
        suspicious = new HashSet<>();
        seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int[] array : invocations) {

            if (!map.containsKey(array[0])) {
                map.put(array[0], new ArrayList<>());
            }

            map.get(array[0]).add(array[1]);
        }

        fillSuspiciousList(k);

        seen = new HashSet<>();
        // [[1,0],[2,0]]
        for (int i = 0; i < n; i++) {
            if (!seen.contains(i) && !suspicious.contains(i) && i != k && !dfs(i)) {
                suspicious = new HashSet<>();
            }
        }

        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    private void fillSuspiciousList(int k) {
        if (seen.contains(k)) {
            return;
        }

        seen.add(k);
        suspicious.add(k);

        for (int n : map.getOrDefault(k, new ArrayList<>())) {
            fillSuspiciousList(n);
        }
    }

    private boolean dfs(int n) {
        boolean flag = true; // false means should be return all the values

        if (seen.contains(n)) {
            return true;
        }

        seen.add(n);
        if (suspicious.remove(n)) {
            return false;
        }

        for (int num : map.getOrDefault(n, new ArrayList<>())) {
            flag = flag && dfs(num);
        }

        return flag;
    }
}