class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];

        Arrays.sort(points, (a, b) ->  euclideanDistance(a) - euclideanDistance(b));

        for(int i = 0;i<k;i++)
        {
            result[i] = points[i];
        }

        return result;
    }

    private int euclideanDistance(int[] array) {
        return (array[0] * array[0]) + (array[1] * array[1]);
    }
}