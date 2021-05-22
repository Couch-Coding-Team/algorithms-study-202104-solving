class Solution {

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (search(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, String word, int n, int i, int j) {
        if (n == word.length()) {
            return true;
        };
        if (isExceedBoardSize(i, j, board)) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (word.charAt(n) != board[i][j]) {
            return false;
        }

        visited[i][j] = true;
        boolean result = search(board, visited, word, n + 1, i - 1, j) ||
            search(board, visited, word, n + 1, i + 1, j) ||
            search(board, visited, word, n + 1, i, j - 1) ||
            search(board, visited, word, n + 1, i, j + 1);
        visited[i][j] = false;
        return result;
    }

    private boolean isExceedBoardSize(int i, int j, char[][] board) {
        return i < 0 || j < 0 || i >= board.length || j >= board[0].length;
    }
}
