class Solution {
    int[][] directions;
    HashSet<String> seen;
    HashSet<String> set;
    int[][] copy;
    List<List<Integer>> result;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length - 1;
        int c = 0;
        seen = new HashSet<>();
        set = new HashSet<>();
        copy = heights;
        result = new ArrayList<>();
        // {r,c}
        directions = new int[][] {
                { 0, -1 }, // left
                { 1, 0 }, // top
                { 0, 1 }, // right
                { -1, 0 },// bottom
        };

        // Atlantic Ocean
        // traversal the bottom row
        c =0;
        r = copy.length - 1;
        for (; c < heights[0].length; c++) {
            dfsAtlantic(r, c);
        }

        c =copy[r].length - 1;
        r = copy.length - 1;
        // traversal the last column
        for (; r >= 0; r--) {
            dfsAtlantic(r, c);
        }

        // Pacific Ocean
        r = 0;
        c = 0;
        seen = new HashSet<>();
        // traversal the top row
        for (; c < heights[0].length; c++) {
            dfsPacific(r, c);
        }

        // traversal the first column
        r = 0;
        c = 0;
        for (; r < heights.length; r++) {
            dfsPacific(r, c);
        }

        return result;

    }

    private void dfsAtlantic(int row, int col) {

        if (seen.contains(row+","+col)) {
            return;
        }

        seen.add(row+","+col);
        set.add(row+","+col);
        

        for (int[] dir : directions) {// left - top - right - bottom
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (isValidCell(nr, nc) && copy[nr][nc] >= copy[row][col]) {
                dfsAtlantic(nr, nc);
            }

        }

    }

    private void dfsPacific(int row, int col) {

        if (seen.contains(row+","+col)) {
            return;
        }

        if (set.contains(row+","+col)) {
            result.add(new ArrayList() {
                {
                    add(row);
                    add(col);
                }
            });
        }

        seen.add(row+","+col);

        for (int[] dir : directions) {// left - top - right - bottom
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (isValidCell(nr, nc) && copy[nr][nc] >= copy[row][col]) {
                dfsPacific(nr, nc);
            }
        }
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < copy.length && col >= 0 && col < copy[0].length;
    }
}