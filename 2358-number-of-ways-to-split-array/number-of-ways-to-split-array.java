class Solution {
    public int waysToSplitArray(int[] nums) {
        long total = 0;
        long prefix = 0;
        int counter = 0;

        for(int n: nums) {
            total+=n;
        }

        for(int i = 0; i < nums.length -1; i++) {
            prefix+=nums[i];
            counter += prefix>= total - prefix?1:0;
        }

        return counter;
    }
}