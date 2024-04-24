class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];

        for(int[] array: bookings) {

            for(int i = array[0] - 1; i < array[1]; i++) {
                result[i] += array[2];
            }
        }

        return result;
    }
}