class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        int l = 0;
        int r = 0;

        for(; r < nums.length; r++) {
            if(nums[l] != 0 && nums[r] != 0) {
                l++;
            } else if (nums[l] == 0 && nums[r] != 0){
                result += ((long)(r - l) * ((r - l) + 1)) / 2;
                l = r + 1;
            }
        }

        result += ((long)(r - l) * ((r - l) + 1)) / 2;

        return result;
    }
}
