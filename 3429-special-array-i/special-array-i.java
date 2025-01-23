class Solution {
    
    public boolean isArraySpecial(int[] nums) {

        for(int i = 1; i < nums.length; i++) {
            boolean first = nums[i -1] % 2 == 0;
            boolean second = nums[i] % 2 == 0;
            if(first == second) {
                return false;
            }
        }


        return true;    
    }
}