public class App {

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        s.solve(board);
        System.out.println("Hello, World!");
    }

}

class Solution {
    int row;
    int col;

    Solution() {

    }

    public static void printArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if (board[i][col - 1] == 'O') {
                dfs(i, col - 1, board);
            }
        }
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if (board[row - 1][i] == 'O') {
                dfs(row - 1, i, board);
            }
        }
        printArray(board);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X')
                    continue;
                if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        printArray(board);
    }

    public void dfs(int y, int x, char[][] board) {
        // base case
        if (board[y][x] == 'X' || board[y][x] == 'F')
            return;
        // recursion rule
        board[y][x] = 'F';
        if (y + 1 < row)
            dfs(y + 1, x, board);
        if (y - 1 >= 0)
            dfs(y - 1, x, board);
        if (x + 1 < col)
            dfs(y, x + 1, board);
        if (x - 1 >= 0)
            dfs(y, x - 1, board);
    }
}