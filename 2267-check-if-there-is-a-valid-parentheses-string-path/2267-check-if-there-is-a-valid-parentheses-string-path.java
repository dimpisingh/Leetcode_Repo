class Solution {
    int[][][] memo;
    public boolean hasValidPath(char[][] grid) {
        int m =grid.length;
        int n = grid[0].length;
        if(grid[0][0] == ')' || grid[m-1][n-1] == '(') return false;
        memo = new int[m][n][m+n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(grid, 0,0,0);
    }

    private boolean dfs(char[][] grid, int i, int j, int bal){
        
        int m = grid.length;
        int n = grid[0].length;

        if(bal < 0) return false;
        if(memo[i][j][bal] != -1) {
            return memo[i][j][bal] == 1;
        }
         int newBalance = bal;
         if(grid[i][j] == '(') newBalance++;
        else newBalance--;
        if(i == m-1 && j == n-1) {
            return newBalance == 0;
        }
         boolean down = false;

        if(i+1 < m) {
            down = dfs(grid, i+1, j, newBalance);
        }

        boolean right = false;

        if(j+1 < n) {
            right = dfs(grid, i, j+1, newBalance);
        }

        boolean ans = down || right;
         memo[i][j][bal] = ans ? 1 : 0;

        return ans;

    }
}