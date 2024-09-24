class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;

        for(int n: arr1) {
            int x = n;
            
            while(x != 0) {
                set.add(x);
                x/=10;
            }
        }

        for(int n : arr2) {
            int x = n;

            while(x != 0) {
                if(set.contains(x)) {
                    result = Math.max(result, ((x + "").length()));
                    break;
                }
                x/=10;
            }
        }


        return result;
    }
}