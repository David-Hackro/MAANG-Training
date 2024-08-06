class Solution {
    boolean[][] seen; // left, bottom, rigth, top
    int[][] directions = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    int max = 0;
    int r;
    int c;

    public int maxAreaOfIsland(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        seen = new boolean[r][c];

        for (int row = 0; row < r; row++) {

            for (int col = 0; col < c; col++) {
                if (grid[row][col] == 1 && !seen[row][col]) {
                    seen[row][col] = true;
                    max = Math.max(max, dfs(row, col, 1, grid));
                }
            }
        }

        return max;
    }

    private boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && row < r && col >= 0 && col < c && !seen[row][col] && grid[row][col] == 1;
    }

    private int dfs(int row, int col, int counter, int[][] grid) {

        for (int[] dir : directions) {
            int r1 = dir[0] + row;
            int c1 = dir[1] + col;

            if (isValid(r1, c1, grid)) {
                seen[r1][c1] = true;
                counter = dfs(r1, c1, counter + 1, grid);
            }
        }

        return counter;
    }

}