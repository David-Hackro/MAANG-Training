class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums.length == 0) {
            result.add(Arrays.asList(lower, upper));
            return result;
        }
        
        if(nums[0] != lower) {
            result.add(Arrays.asList(lower, nums[0] - 1)); 
        }

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] > 1) {
                result.add(Arrays.asList(nums[i - 1] + 1, nums[i] - 1));
            }
        }

        if(nums[nums.length - 1] != upper) {
            result.add(Arrays.asList(nums[nums.length - 1] + 1, upper));
        }


        return result;

    }
}