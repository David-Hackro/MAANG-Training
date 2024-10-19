class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int counter = 0;

        for (int start = 0; counter < n; start++) {
           int current = start;//0
           int currentValue = nums[current];//1
            do {
                //Input: nums = [1,2,3,4,5,6,7], k = 3
                int next = (current + k) % n;//3
                int nextValue = nums[next];//4
                nums[next] = currentValue;//replace 4 to 1
                currentValue = nextValue;
                current = next;
                counter++; 
            } while( start != current);

        }
    }
}