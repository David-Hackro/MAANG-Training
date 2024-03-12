class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int result = -1;
        int l = 0;
        int r = nums.length - 1;
        int temp = 0;

        while(l < r) {
            temp = nums[l] + nums[r];

            if(temp < k) {
                result = Math.max(result, temp);
                l++;
            } else {
                r--;
            }
        }

        return result;
    }
}