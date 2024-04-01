class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int result = 0;
        int current = 1;    
        int l = 0;

        for(int r = 0; r < nums.length; r++) {
            current *= nums[r];

            while(current >= k && l <= r) {
                current /= nums[l];
                l++;
            }

            result += r - l + 1;
        }

        return result;
    }
}