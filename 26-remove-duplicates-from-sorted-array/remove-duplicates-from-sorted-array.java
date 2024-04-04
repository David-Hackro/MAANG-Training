class Solution {
    public int removeDuplicates(int[] nums) {
        int last = 0;
        int result = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[last] != nums[i]) {
                last++;
                nums[last] = nums[i];
                result++;
            }
        }

        return result;       
    }
}