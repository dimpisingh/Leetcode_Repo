class Solution {
    static int helper(int[][] grid, int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n) return 0;
        if(grid[i][j]==0) return 0;
        grid[i][j]=0;
        int rect=1;
        rect+=helper(grid,i-1,j,m,n);
        rect+=helper(grid,i,j-1,m,n);
        rect+=helper(grid,i+1,j,m,n);
        rect+=helper(grid,i,j+1,m,n);

        return rect;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int rect = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int rec = helper(grid, i,j,m,n);
                if(rect < rec){
                    rect = rec;
                }
            }
        }
        return rect;
    }
}