class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int result = 0;
        int prev = 0;
        int size = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums) {
            set.add(n);
        }

        size = set.size();

        for(int i = 0; i < nums.length; i++) {
            set.clear();

            for(int j = i; j < nums.length; j++) {
                set.add(nums[j]);
                if(set.size() == size) {
                    result++;
                }
            }

            if(prev == result) { return result; }
            prev = result;
        }

        return result;
    }
}