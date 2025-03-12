class Solution {

    int[][] directions;

    public int minimumEffortPath(int[][] heights) {
        int l = 0;
        int r = 0;// get the max value in the matrix
        int m = (l + r) / 2;
        int result = 0;

        directions = new int[][] {
                // r,c
                { 0, 1 }, // right
                { 1, 0 }, // bottom
                { 0, -1 }, // left
                { -1, 0 },// up
        };

        // get the max value in the matrix
        for (int[] row : heights) {
            for (int c : row) {
                r = Math.max(r, c);
            }
        }

        while (l <= r) {
            // calculate the media
            m = (l + r) / 2;// 4
            boolean isValidPathWithTheMedia = dfs(heights, 0, 0, m, new HashSet<String>());

            // when is true, means that found a path with this abs difference
            if (isValidPathWithTheMedia) {
                r = m - 1;
                result = m;
            } else {
                l = m + 1;
            }
        }

        return result;
    }

    private boolean dfs(int[][] heights, int row, int col, int m, HashSet<String> seen) {

        if (seen.contains(row + "," + col)) {
            return false;
        }

        seen.add(row + "," + col);

        for (int[] dir : directions) {// right,bottom,left,up
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (!isValid(nr, nc, heights)) {
                continue;
            }

            int abs = Math.abs(heights[row][col] - heights[nr][nc]);
            boolean isPosiblePath = abs <= m;
            boolean isTargetCell = nr == heights.length - 1 && nc == heights[0].length - 1;

            if(isTargetCell) {
                return isPosiblePath;
            } 

            if (isPosiblePath && dfs(heights, nr, nc, m, seen)) {
                return true;
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, int[][] heights) {
        return row >= 0 && row < heights.length && col >= 0 && col < heights[0].length;
    }
}