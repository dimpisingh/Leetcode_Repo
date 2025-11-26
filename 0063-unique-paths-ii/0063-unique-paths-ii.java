class Solution {
    int[][] dp;
    int res = 0;

    int dfs(int i, int j, int m, int n, int[][] grid) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (grid[i][j] == 1)
            return 0;
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int a = dfs(i + 1, j, m, n, grid);
        int b = dfs(i, j + 1, m, n, grid);
        dp[i][j] = a + b;
        return dp[i][j];

    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(0, 0, m, n, grid);
    }
}
