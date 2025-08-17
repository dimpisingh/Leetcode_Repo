class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts - 1) return 1.0; // edge case

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double wsum = 1.0, prob = 0.0;

        // sliding window with window size maxPts
        for (int l = 0, r = 1; r <= n; r++) {
            dp[r] = wsum / maxPts;
            if (r < k) {
                wsum += dp[r];
            } else {
                prob += dp[r];
            }

            if (r >= maxPts) {
                wsum -= dp[l++];
            }
        }

        return prob;
    }
}
