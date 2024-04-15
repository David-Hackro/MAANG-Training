
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        Iterator<Integer> iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            int t = iterator1.next();

            if (set2.contains(t)) {
                iterator1.remove();
                set2.remove(t);
            }
        }

        List<Integer> s1 = new ArrayList<>(set1);
        List<Integer> s2 = new ArrayList<>(set2);

        result.add(s1);
        result.add(s2);

        return result;
    }
}
