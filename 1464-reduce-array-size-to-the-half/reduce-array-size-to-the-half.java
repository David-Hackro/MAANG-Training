class Solution {
    public int minSetSize(int[] arr) {
        int target = arr.length / 2;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());

        Collections.sort(list, Collections.reverseOrder());

        for (int n : list) {
            target -= n;
            result++;

            if (target <= 0) {
                return result;
            }
        }

        return result;
    }
}