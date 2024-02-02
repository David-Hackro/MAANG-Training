class Solution {
    public int[][] divideArray(int[] nums, int k) {
        
        int[][] result = new int[(nums.length / 3)][3];
        int r = 0;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i+=3) {

            if(nums[i + 2] - nums[i] <= k) {
                
                result[r][0] = nums[i];
                result[r][1] = nums[i + 1];
                result[r][2] = nums[i + 2];
                r++;
            } else {
                return new int[0][0];
            }
        }

        return result;
    }
}