class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefix = 0;
        long ans = Long.MIN_VALUE;

        // minPrefix[r] = smallest prefix sum seen with remainder r
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);

        // Base case: prefix sum = 0 at index -1 -> remainder 0
        minPrefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix += nums[i];

            int rem = (i + 1) % k;

            // Kadane-style transition
            if (minPrefix[rem] != Long.MAX_VALUE) {
                ans = Math.max(ans, prefix - minPrefix[rem]);
            }

            // Keep best (minimum) prefix for this remainder
            minPrefix[rem] = Math.min(minPrefix[rem], prefix);
        }

        return ans;
    }
}