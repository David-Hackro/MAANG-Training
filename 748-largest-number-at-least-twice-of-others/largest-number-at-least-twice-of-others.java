class Solution {
    public int dominantIndex(int[] nums) {
        int max_val = 0;
        int max_index = 0;
        int prev_max_val = 0;
        int prev_max_index = 0;
        int i = 0;

        for(int n : nums) {
            if(n != max_val) {
                if(n > max_val) {
                    prev_max_val = max_val;
                    prev_max_index = max_index;
                    max_val = n;
                    max_index = i;
                } else if(n > prev_max_val) {
                    prev_max_val = n;
                    prev_max_index = i;
                }
            }

            i++;
        }

        if(prev_max_val * 2 <= max_val) {
            return max_index;
        }

        return -1;
    }
}