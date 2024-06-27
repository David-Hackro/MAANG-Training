class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int n : nums) {
            min = Math.min(min, n);
        }

        return min;
    }
}