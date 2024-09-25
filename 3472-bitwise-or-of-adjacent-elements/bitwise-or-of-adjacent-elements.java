class Solution {
    public int[] orArray(int[] nums) {
        int[] result= new int[nums.length -1];

        for(int i = 0; i < nums.length - 1; i++) {
            result[i] = nums[i] | nums[i + 1]; 
        }

        return result;
    }
}