package backtracking_kushwah;

public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        Knights(board, 0, 0, 3);
    }

    static void Knights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            return;
        }

        if (row == board.length) {
            return; // reached past last row
        }

        if (col == board.length) {
            Knights(board, row + 1, 0, knights); // next row
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            Knights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        Knights(board, row, col + 1, knights);
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        int[][] moves = {
                {-2, -1}, {-2, +1},
                {-1, -2}, {-1, +2}
        };
        for (int[] m : moves) {
            int r = row + m[0];
            int c = col + m[1];
            if (r >= 0 && c >= 0 && r < board.length && c < board.length) {
                if (board[r][c]) return false;
            }
        }
        return true;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
