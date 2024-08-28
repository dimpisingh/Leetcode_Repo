class Solution {
    static int robs(int[] a, int n) {
        int prev = a[0];
        int prev2 = 0;
        int cur = -1;

        for (int i = 1; i < n; i++) {
            int t = a[i];
            if (i > 1)
                t += prev2;
            int nt = 0 + prev;
            cur = Math.max(t, nt);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        // int[] dp =new int[n+1];
        return robs(nums, n);

    }
}