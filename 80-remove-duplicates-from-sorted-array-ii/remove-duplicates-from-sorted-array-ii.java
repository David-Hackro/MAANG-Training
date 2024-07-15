class Solution {
    public int removeDuplicates(int[] nums) {
        
        int l = 0;
        int r = 1;
        int n = nums[0];
        int counter = 1;
        //[1,1,1,2,2,3]
        for(;r < nums.length; r++) {
            
            if(n == nums[r]) {
                counter++;
            } else {
                nums[l++] = n;
                if(counter > 1) {
                    nums[l++] = n;
                }
                n = nums[r];
                counter = 1;
            }
        }

        nums[l++] = n;

        if(counter > 1) {
            nums[l++] = n;
        }

        return l;
    }
}