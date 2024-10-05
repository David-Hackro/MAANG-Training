class Solution {
    int row;
    int col;

    public void wallsAndGates(int[][] rooms) {
        int[][] directions = new int[][] {
                // {r, c}
                { 0, -1 }, // left
                { 1, 0 }, // top
                { 0, 1 }, // right
                { -1, 0 },// bottom
        };

        row = rooms.length - 1;
        col = rooms[0].length - 1;

        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();

        for (int r = 0; r < rooms.length; r++) {
            for (int c = 0; c < rooms[r].length; c++) {
                if (rooms[r][c] == 0) {
                    int counter = 0;
                    // BFS
                    queue.add(new int[] { r, c });// gate
                    seen = new HashSet<>();
                    seen.add(r + "," + c);
                    while (!queue.isEmpty()) {
                        int size = queue.size();

                        for (int i = 0; i < size; i++) {
                            int[] slot = queue.remove();
                            seen.add(slot[0] + "," + slot[1]);

                            for (int[] dir : directions) {
                                int newRow = slot[0] + dir[0];
                                int newColum = slot[1] + dir[1];

                                if (isValidDirection(newRow, newColum) &&
                                        rooms[newRow][newColum] != -1 && rooms[newRow][newColum] != 0
                                        && !seen.contains(newRow + "," + newColum) &&
                                        rooms[newRow][newColum] != counter + 1) {
                                    // this is a path
                                    if (rooms[newRow][newColum] == Integer.MAX_VALUE) {
                                        rooms[newRow][newColum] = counter + 1;
                                    }

                                    rooms[newRow][newColum] = Math.min(counter + 1, rooms[newRow][newColum]);
                                    queue.add(new int[] { newRow, newColum });
                                }
                            }
                        }

                        counter++;
                    }
                }
            }
        }
    }

    private boolean isValidDirection(int r, int c) {// is inside the map
        return r >= 0 && r <= row && c >= 0 && c <= col;
    }
}