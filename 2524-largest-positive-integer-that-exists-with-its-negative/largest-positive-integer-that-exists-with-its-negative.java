class Solution {
    public int findMaxK(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        Arrays.sort(nums);

        while(i < j) {
            if(nums[i] < 0 && nums[j] >= 0) {

                if(Math.abs(nums[i]) == nums[j]) {
                    return nums[j];
                }

                if(Math.abs(nums[i]) < nums[j]) {
                    j--;
                } else {
                    i++;
                }

            } else {
                return -1;
            }
        }       

        return -1;
    }
}