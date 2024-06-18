class Solution {
    public int equalPairs(int[][] grid) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for(int[] array: grid) {
            String s = Arrays.toString(array);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }        

        int[] t = new int[grid.length];

        for(int c = 0; c < grid.length; c++) {
            for(int r = 0; r < grid.length; r++) {
                t[r]= grid[r][c];
            }
            
            result += map.getOrDefault(Arrays.toString(t), 0);
        }

        return result;
    }
}