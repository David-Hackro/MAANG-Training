class Solution {
    int[][] directions = new int[][] {
            // row, col
            { 0, -1 }, // left}
            { 1, 0 }, // top
            { 0, 1 }, // right
            { -1, 0 },// bottom
    };
    HashSet<String> seen;
    int m;// row
    int n;// col

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        seen = new HashSet<>();

        queue.add(new int[] { start[0], start[1] });
        seen.add(getHash(start[0], start[1]));// visited

        while (!queue.isEmpty()) {
            int[] item = queue.remove();
            int cr = item[0];
            int cc = item[1];

            if (destination[0] == cr && destination[1] == cc) {
                return true;
            }

            for (int[] direction : directions) {
                int nr = cr + direction[0];
                int nc = cc + direction[1];

                if (isValid(nr, nc) && maze[nr][nc] == 0) {// is valid move in this directions?

                    // move in this direction until hit a wall
                    while (isValid(nr, nc) && maze[nr][nc] == 0) {
                        nr += direction[0];
                        nc += direction[1];
                    }

                    nr -= direction[0];
                    nc -= direction[1];
                    
                    if (!seen.contains(getHash(nr, nc))) {
                        queue.add(new int[] { nr, nc });
                        seen.add(getHash(nr, nc));
                    }
                }
            }

        }

        return false;
    }

    // help me to define if the next direction is available
    private boolean isValid(int r, int c) {// status == 0/1
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    private String getHash(int r, int c) {
        return r + "," + c;
    }
}