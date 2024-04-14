class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int result = 0;
        int ones = 0;
        int zeros = 0;

        for(; r < nums.length; r++) {
            ones += nums[r] == 1?1:0;
            zeros += nums[r] == 0?1:0;

            while(zeros > 1) {
                ones -= nums[l] == 1?1:0;
                zeros -= nums[l] == 0?1:0;
                l++;
            }
        
            result = Math.max(result, r - l +1);
            
        }

        return result - 1;
    }
}