class Solution {
    int[][] directions;

    public int minimumEffortPath(int[][] heights) {
        directions = new int[][] {
                // r,c
                { 0, 1 }, // right
                { 1, 0 }, // bottom
                { 0, -1 }, // left
                { -1, 0 },// up
        };
        int m = heights.length;
        int n = heights[0].length;
        int l = 0;
        int r = 0;

        if (m == 1 && n == 1) {
            return 0;
        }

        for (int[] row : heights) {
            for (int col : row) {
                r = Math.max(r, col);
            }
        }
        int res = 0;

        while (l <= r) {
            int media = (l + r) / 2;

            if (bfs(heights, media)) {
                r = media - 1;
            } else {
                l = media + 1;
            }
        }

        if (l < r) {
            return -1;
        }

        return l;
    }

    private boolean bfs(int[][] heights, int media) {
        int m = heights.length;
        int n = heights[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        queue.add(new int[] { 0, 0 });
        seen[0][0] = true;

        while (!queue.isEmpty()) {
            int[] item = queue.remove();
            int itemRow = item[0];
            int itemCol = item[1];

            // validate directions
            for (int[] dir : directions) {
                int nr = itemRow + dir[0];
                int nc = itemCol + dir[1];

                if (isValid(nr, nc, m, n) && !seen[nr][nc]
                        && Math.abs(heights[itemRow][itemCol] - heights[nr][nc]) <= media) {

                    if (nr == m - 1 && nc == n - 1) {
                        return true;
                    }

                    seen[nr][nc] = true;
                    queue.add(new int[] { nr, nc });
                }
            }
        }

        return false;
    }

    private boolean isValid(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}