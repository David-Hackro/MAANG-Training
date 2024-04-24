class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];

        for (int[] array: bookings) {
            result[array[0] - 1] += array[2];
            if(array[1] != n) {
                result[array[1]] -= array[2];
            }
        }

        for(int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
}