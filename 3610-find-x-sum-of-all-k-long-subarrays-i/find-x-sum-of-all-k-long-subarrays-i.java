class Solution {

    public int[] findXSum(int[] nums, int k, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> frecuencies;
        List<Integer> keys;
        int total;
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // perfome the operations only where have the min size
            if (i + 1 >= k) {
                frecuencies = new ArrayList<>(map.values());
                keys = new ArrayList<>(map.keySet());
                Collections.sort(frecuencies);
                Collections.sort(keys);
                total = 0;
                int iterations = 0;
                frecuencies = frecuencies.subList(Math.max(0, frecuencies.size() - x), frecuencies.size());
                for (int r = keys.size() - 1; r >= 0; r--) {

                    if (frecuencies.contains(map.get(keys.get(r)))) {
                        int ke = keys.get(r);
                        int fe = map.get(keys.get(r));
                        total = total + (ke * fe);
                        frecuencies.remove(new Integer(fe));
                    }

                }

                result[index++] = total;
                map.put(nums[i - k + 1], map.get(nums[i - k + 1]) - 1);

                if (map.get(nums[i - k + 1]) == 0) {
                    map.remove(nums[i - k + 1]);
                }
            }
        }

        return result;
    }
}