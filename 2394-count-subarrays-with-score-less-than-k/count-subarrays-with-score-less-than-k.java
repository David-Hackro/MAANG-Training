class Solution {
    public long countSubarrays(int[] nums, long k) {
        int l = 0;
        int r = 0;
        long counter = 0;
        long acumulator = 0;
        long calculus = 0l; // sum numbers and multiply by the lenght

        for (; r < nums.length; r++) {

            acumulator += nums[r];// 5
            calculus = acumulator * (r - l + 1);

            while (calculus >= k && l <= r) {
                acumulator -= nums[l];
                l++;
                calculus = acumulator * (r - l + 1);
            }

            counter += (r - l + 1);
        }

        return Long.valueOf(counter);
    }
}