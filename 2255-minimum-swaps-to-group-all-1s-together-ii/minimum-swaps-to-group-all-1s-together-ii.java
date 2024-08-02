class Solution {
    public int minSwaps(int[] nums) {
        int l = 0;       
        int r = 0;
        int i = 0;
        int counter = 0;
        int total = 0;
        int min = Integer.MAX_VALUE;

        for(int n : nums) {
            total +=n;
        }

        for(; r < total; r++) {
            counter += nums[r];
        }

        min = Math.min(min, total - counter);
        
        for(; r <= nums.length + total -1; r++) {
            
            counter += nums[r >= nums.length?i++:r];
            counter -= nums[l];    
            min = Math.min(min, total - counter);
            l++;
            
        }


        return min == Integer.MAX_VALUE?0:min;
    }
}