class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,  Integer> map = new HashMap<>();
        int prefix = 0;
        int res = 0;

        //k = 7
        // 23,25,29,35,42
        //[23, 2, 4, 6, 6]
        //
        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            res = prefix % k;

            //verify if prev appeared another equal res
            if(res == 0 && i > 0 || (map.containsKey(res) && i - map.get(res) >= 2)) {
                return true;
            } else if(!map.containsKey(res)) {//where is the first time that appear
                map.put(res, i);
            }
        }

        return false;

    }
}