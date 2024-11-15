class Solution {
    
    int dfs(int m, int n, int i, int j, int[][] dp){
        if(i>=m || j>=n) return 0;
        //int down, right;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=0) return dp[i][j];
        int down= dfs(m,n,i+1,j,dp);
        int right= dfs(m,n,i,j+1,dp);
        dp[i][j] = down+right;
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return dfs(m,n,0,0,dp);
    }
}