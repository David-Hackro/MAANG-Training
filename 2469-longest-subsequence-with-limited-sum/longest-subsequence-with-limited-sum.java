class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        int[] prefix = new int[nums.length];
    

        Arrays.sort(nums);

        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i -1]; 
        }

        for(int i = 0; i < queries.length; i++) {
            ans[i] = getMaxSubSequence(prefix, queries[i]);
        }

        return ans;
    }


    private int getMaxSubSequence(int[] prefix, int query) {
        int l = 0;
        int r = prefix.length -1;
        int m = (l + r) / 2;
        int last = 0;

        while(l <= r) {
            m = (l + r) / 2;
          
            if(prefix[m] == query) {
                return m + 1;
            }

            if(prefix[m] > query) {
                r = m - 1;
            }  else {
                last = m + 1;
                l = m + 1;
            }
        }

        return last;
    }
}