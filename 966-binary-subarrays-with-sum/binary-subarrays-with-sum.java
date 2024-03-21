class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int result = 0;
        int sum = 0;

        for(int n : nums) {
            sum += n;

            result += map.getOrDefault(sum - goal, 0);

            map.put(sum, map.getOrDefault(sum,0) + 1);
        }

        return result;
    }
}