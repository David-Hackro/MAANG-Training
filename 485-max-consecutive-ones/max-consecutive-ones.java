class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int counter = 0;

        for(int n : nums) {
            
            if(n == 0){
                counter = 0;
                continue;
            } {
            counter++;
             
            }

            max = Math.max(max, counter);
        }

        return max;
    }
    
}