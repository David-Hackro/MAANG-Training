class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        for (; i < nums.length - 2; i++) {
            int t = nums[i];
            j = i + 1;
            k = nums.length - 1;

            while (j < k) {

                if (t + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (t + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }

        }
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        arrayList.addAll(res);

        return arrayList;
    }
}