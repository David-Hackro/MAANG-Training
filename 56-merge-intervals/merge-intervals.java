class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] interval = intervals[0];
        int[][] result;
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 1; i < intervals.length; i++) {
            
            if(interval[1] >= intervals[i][0]) {
                interval[1] = Math.max(interval[1], intervals[i][1]);
            } else {
                list.add(interval);
                interval = intervals[i];
            }
        }        

        list.add(interval);

        result = new int[list.size()][2];
        int i = 0;
        for(int[] a: list) {
            result[i++] = a;
        }

        return result;
    }
}