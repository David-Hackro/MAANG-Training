class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefix = 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(prefix, 1);

        for(int n: nums) {
            prefix += n;

            result+= map.getOrDefault(prefix - goal, 0);

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return result;
    }
}