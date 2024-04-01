class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();


        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);

            if(map.get(n) == (nums.length / 3) + 1) {
                result.add(n);
            }
        }
    
        return result;
    }
}