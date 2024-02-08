class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        int l = 0;

        HashSet<Integer> hashSet = new HashSet<>();
        
        for(int n: nums) {
            hashSet.add(n);
        }

        int[] array = new int[hashSet.size()];
        int index = 0;
        for (Integer value : hashSet) {
            array[index++] = value;
        }
        
        Arrays.sort(array);
        
        for(int r = 0; r < array.length; r++) {

            while(array[l] + (r - l) != array[r] && 
                  array[l] != array[r]) {
                l++;
            }

            max = Math.max(max, r - l + 1);
        }       


        return max;
    }
}