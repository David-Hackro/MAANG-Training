class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        int units = 0;
        Arrays.sort(boxTypes, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        for (int i = boxTypes.length - 1; i >= 0; i--) {
            int[] a = boxTypes[i];

            if (a[0] <= truckSize) {
                truckSize -= a[0];// 5 - 3 = 2
                units = a[0] * a[1]; // 27
                result += units; // 0 + 50 + 27
            } else if (truckSize > 0) { // number is greather that truckSize
                units = truckSize * a[1]; // 2 * 7 = 14
                result += units;// 0 + 50 + 27 + 14
                return result;
            }
            units = 0;
        }

        return result;
    }
}
