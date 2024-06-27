class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length -1;

        while(l <= r) {
            min = Math.min(min, nums[l]);
            min = Math.min(min, nums[r]);
            l++;
            r--;
        }

        return min;
    }
}