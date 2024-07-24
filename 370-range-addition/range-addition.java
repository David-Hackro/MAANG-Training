class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];

        for(int[] array: updates) {
            int l = array[0];
            int r = array[1];
            int x = array[2];

            for(int i = l; i <= r; i++) {
                result[i] += x;
            }
        }

        return result;
    }
}