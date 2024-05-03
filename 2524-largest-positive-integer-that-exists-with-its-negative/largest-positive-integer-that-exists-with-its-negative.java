class Solution {
    public int findMaxK(int[] nums) {
        // Initialize the indices i and j to start from the beginning and the end of the array
        int i = 0;
        int j = nums.length - 1;

        // Sort the array to facilitate binary search
        Arrays.sort(nums);

        // Perform binary search
        while(i < j) {
            // Check if i points to a negative number and j points to a non-negative number
            if(nums[i] < 0 && nums[j] >= 0) {
                // If the absolute value of nums[i] is equal to nums[j], return nums[j] as it's the maximum K
                if(Math.abs(nums[i]) == nums[j]) {
                    return nums[j];
                }
                // If the absolute value of nums[i] is less than nums[j], move j to the left
                else if(Math.abs(nums[i]) < nums[j]) {
                    j--;
                } 
                // If the absolute value of nums[i] is greater than nums[j], move i to the right
                else {
                    i++;
                }
            } 
            // If the elements pointed by i and j do not meet the condition, return -1
            else {
                return -1;
            }
        }       

        // If no K value satisfying the conditions is found, return -1
        return -1;
    }
}
