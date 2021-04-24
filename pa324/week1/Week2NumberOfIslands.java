class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m+1][n+1];        
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid,i,j,visited);
                    result++;
                }                 
            }
        }
        return result;
    }
    public void dfs(char[][] grid, int x, int y, boolean[][] visited) {    
        if(x >= grid.length || y >= grid[0].length || x < 0  || y < 0) { 
            return;
        }
        if(grid[x][y] == '0' || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
     
        dfs(grid,x+1,y,visited);
        dfs(grid,x-1,y,visited);
        dfs(grid,x,y+1,visited);
        dfs(grid,x,y-1,visited);
    }
    
}
