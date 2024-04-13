class Solution {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        int i = 0;
        int j = nums.length -1;
        Arrays.sort(nums);
        int t = 0;

        while( i < j) {
        	t = nums[i] + nums[j];
        	
        	if(t == k) {
        		result++;
        		i++;
        		j--;
        	} else if(t < k) {
        		i++;
        	} else {
        		j--;
        	}
        }

        return result;
    }
}