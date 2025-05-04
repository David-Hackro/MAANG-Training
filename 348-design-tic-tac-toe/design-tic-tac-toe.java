class TicTacToe {

    int[] path;
    int size;

    public TicTacToe(int n) {
        size = n;
        path = new int[(n * 2) + 2];
    }

    public int move(int row, int col, int player) {
        int[] temp = path;

        boolean isDiagonalA = row + col == size -1;// /
        boolean isDiagonalB = row == col;// \

        int t = 1;

        if (player == 2) {
            t = -1;
        }

        path[row] += t;
        path[size + col] += t;

        if (isDiagonalA) {
            path[((size * 2))] += t;
        }

        if (isDiagonalB) {
            path[(size * 2) + 1] += t;
        }

        if (    
            Math.abs(path[row]) == size || //horizontal
            Math.abs(path[size + col]) == size || //vertical
            Math.abs(path[size * 2]) == size || //Diagonal /
            Math.abs(path[(size * 2) + 1]) == size) { // Diagonal \
            
            return player;
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */