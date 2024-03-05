class Solution {
    public int countKDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n: nums) {
            if(n == k) {
                result += map.getOrDefault((n * 2), 0);
            } else {
                result += map.getOrDefault((n - k), 0);
            }

            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        return result;
    }
}