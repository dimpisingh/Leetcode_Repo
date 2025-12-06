class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        final int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> maxDQ = new ArrayDeque<>();
        Deque<Integer> minDQ = new ArrayDeque<>();

        int l = 0;

        for (int r = 0; r < n; r++) {
            while (!maxDQ.isEmpty() && nums[maxDQ.peekLast()] <= nums[r]) {
                maxDQ.pollLast();
            }
            maxDQ.offerLast(r);

            while (!minDQ.isEmpty() && nums[minDQ.peekLast()] >= nums[r]) {
                minDQ.pollLast();
            }
            minDQ.offerLast(r);

            while (!maxDQ.isEmpty() && !minDQ.isEmpty() &&
                    nums[maxDQ.peekFirst()] - nums[minDQ.peekFirst()] > k) {
                if (maxDQ.peekFirst() == l) maxDQ.pollFirst();
                if (minDQ.peekFirst() == l) minDQ.pollFirst();
                l++;
            }

            int left = l;
            int right = r;

            long ways;
            if (left == 0) {
                ways = pref[right];
            } else {
                ways = (pref[right] - pref[left - 1]) % MOD;
                if (ways < 0) ways += MOD;
            }

            dp[r + 1] = ways;
            pref[r + 1] = (pref[r] + dp[r + 1]) % MOD;
        }

        return (int) (dp[n] % MOD);
        
    }
}