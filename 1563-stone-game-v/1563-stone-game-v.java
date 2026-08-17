class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        // Prefix sum
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stoneValue[i];
        }

        // dp[l][r] = maximum score for subarray l...r
        int[][] dp = new int[n][n];

        // Length 1 -> score is 0
        // Build from smaller intervals to larger intervals
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;

                for (int mid = l; mid < r; mid++) {

                    int leftSum = pre[mid + 1] - pre[l];
                    int rightSum = pre[r + 1] - pre[mid + 1];

                    if (leftSum < rightSum) {
                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + dp[l][mid]
                        );
                    } 
                    else if (leftSum > rightSum) {
                        dp[l][r] = Math.max(
                            dp[l][r],
                            rightSum + dp[mid + 1][r]
                        );
                    } 
                    else {
                        dp[l][r] = Math.max(
                            dp[l][r],
                            Math.max(
                                leftSum + dp[l][mid],
                                rightSum + dp[mid + 1][r]
                            )
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}