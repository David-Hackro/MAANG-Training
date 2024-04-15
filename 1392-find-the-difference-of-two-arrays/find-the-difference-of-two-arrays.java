
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;

        while(i < Math.max(nums1.length, nums2.length)) {
            if(i < nums1.length) {
                set1.add(nums1[i]);
            } 

            if(i < nums2.length) {
                set2.add(nums2[i]);
            }

            i++;
        }

        Iterator<Integer> iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            int t = iterator1.next();

            if (set2.contains(t)) {
                iterator1.remove();
                set2.remove(t);
            }
        }


        result.add( new ArrayList<Integer>(set1));
        result.add(new ArrayList<Integer>(set2));

        return result;
    }
}
