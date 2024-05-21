class Solution {
    public int islandPerimeter(int[][] grid) {
        int counter = 0;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 0) {
                    continue;
                }
                //left
                if(c == 0 || grid[r][c - 1] == 0) {
                    counter++;
                }
                //up
                if(r == 0 || grid[r - 1][c] == 0) {
                    counter++;
                }

                //right
                if(c == grid[r].length -1 || grid[r][c + 1] == 0) {
                    counter++;
                }

                //bottom
                if(r == grid.length -1 || grid[r + 1][c] == 0) {
                    counter++;
                }

            }       
        }       

        return counter;
    }
}