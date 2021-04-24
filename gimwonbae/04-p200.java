class p200 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R;
    static int C;

    public int numIslands(char[][] grid) {
        R = grid.length;
        C = grid[0].length;
        int ans = 0;
        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '0';
        for (int i = 0; i < 4; i++){
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (0 <= newR && newR < R && 0 <= newC && newC < C && grid[newR][newC] == '1'){
                dfs(grid, newR, newC);
            }
        }
    }
}