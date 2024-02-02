class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        

        if(nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }

        int[] c1 = new int[10001];
        int i = 0;

        for(int num : nums1) {
            c1[num]++;
        }      

        for(int num : nums2){
            
            if(c1[num] > 0) {
                nums1[i++]= num;
                c1[num]--;
            }
        }


        return Arrays.copyOfRange(nums1, 0, i);
    }
}