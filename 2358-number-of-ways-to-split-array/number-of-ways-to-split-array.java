class Solution {
    public int waysToSplitArray(int[] nums) {
        int result = 0;
        long[] copy = new long[nums.length];
        copy[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {        
            copy[i] = nums[i] + copy[i - 1];
        }

        for (int i = 0;i < copy.length -1; i++) {

            if ((copy[copy.length - 1] - copy[i]) <= copy[i]) {
                result++;
            }
        }

        return result;
    }
}