class Solution {
    public int minOperations(int[] nums) {

        int r = nums.length - 2;
        int result = 0;

        for (; r >= 0; r--) {

            if (nums[r + 1] >= nums[r]) {
                continue;
            } else {
                int divisor = getDivisor(r, nums);

                if(divisor == -1) {
                    return -1;
                } 

                
                nums[r] = divisor;
                result++;
            }
        }

        return result;
    }

    private int getDivisor(int r, int[] nums) {
        int n = nums[r];
        
        for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return (nums[r + 1] >= i)?i: -1;
            }
        }


        return -1;
    }
}