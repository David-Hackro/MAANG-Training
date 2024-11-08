class Solution {
    int[][] directions;
    // [row, col, steps, k]
    HashSet<String> seen;
    int m;
    int n;

    public int shortestPath(int[][] grid, int k) {
        directions = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
        m = grid.length;
        n = grid[0].length;
        int result = Integer.MAX_VALUE;
        seen = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { 0, 0, 0, k });

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] node = queue.remove();// 0,0,0,0
                int oldRow = node[0];
                int oldCol = node[1];
                int steps = node[2];
                int counter = node[3]; // counters means current blocks

                if ((oldRow == m - 1 && oldCol == n - 1)) {
                    return steps;
                }

                if (seen.contains(hashArray(node))) {
                    continue;
                }

                seen.add(hashArray(node));

                for (int[] direction : directions) {
                    int newRow = oldRow + direction[0];
                    int newCol = oldCol + direction[1];

                    if (isValid(newRow, newCol) && (grid[newRow][newCol] == 0 || counter > 0)) {

                        int[] array = new int[] { newRow, newCol, steps + 1, (counter - grid[newRow][newCol]) };

                        queue.add(array);
                    }
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    private String hashArray(int[] array) {
        StringBuilder sb = new StringBuilder();

        sb.append(array[0]);
        sb.append(",");
        sb.append(array[1]);
        sb.append(",");
        sb.append(array[3]);

        return sb.toString();
    }
}