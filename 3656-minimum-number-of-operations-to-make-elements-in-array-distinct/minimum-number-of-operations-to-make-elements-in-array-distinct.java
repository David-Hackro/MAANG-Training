class Solution {
    public int minimumOperations(int[] nums) {
        // Input: nums = [1,2,3,4,2,3,3,5,7]

        HashMap<Integer,  Integer> map = new HashMap<>();
        int result = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>(map.values());

        if (set.size() == 1 && set.iterator().next() == 1) {
            return result;
        }

        for (int i = 0; i < nums.length - 3;) {
            result++;
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];

            map.put(a, map.get(a) - 1);
            map.put(b, map.get(b) - 1);
            map.put(c, map.get(c) - 1);

            if (map.containsKey(a) && map.get(a) == 0) {
                map.remove(a);
            }

            if (map.containsKey(b) && map.get(b) == 0) {
                map.remove(b);
            }

            if (map.containsKey(c) && map.get(c) == 0) {
                map.remove(c);
            }

            set = new HashSet<>(map.values());

            if (set.size() == 1 && set.iterator().next() == 1) {
                return result;
            }
        
            i+=3;
        }

        for( int n : set) {
            if(n > 1) {
                result++;
            }
        }
        

        return result;
    }
}