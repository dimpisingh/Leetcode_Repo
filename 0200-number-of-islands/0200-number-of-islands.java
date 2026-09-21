class Solution {
    private static void dfs(int i, int j, int nr, int nc, char[][] grid) {
        grid[i][j] = 0;
        if (i - 1 >= 0 && grid[i - 1][j] == '1')
            dfs(i - 1, j, nr, nc, grid);
        if (i + 1 < nr && grid[i + 1][j] == '1')
            dfs(i + 1, j, nr, nc, grid);
        if (j - 1 >= 0 && grid[i][j - 1] == '1')
            dfs(i, j - 1, nr, nc, grid);
        if (j + 1 < nc && grid[i][j + 1] == '1')
            dfs(i, j + 1, nr, nc, grid);
    }

    public int numIslands(char[][] grid) {
        int nr = grid.length, cnt = 0;
        int nc = grid[0].length;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, nr, nc, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}