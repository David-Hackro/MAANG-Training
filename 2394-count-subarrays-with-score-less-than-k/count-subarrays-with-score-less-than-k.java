class Solution {
    public long countSubarrays(int[] nums, long k) {
        int l = 0;
        int r = 0;
        long counter = 0;
        long acumulator = 0;

        for (; r < nums.length; r++) {

            acumulator += nums[r];

            while (acumulator * (r - l + 1) >= k) {
                acumulator -= nums[l++];
            }

            counter += (r - l + 1);
        }

        return counter;
    }
}
