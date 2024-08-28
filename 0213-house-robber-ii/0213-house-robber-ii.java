class Solution {
    static int robs(int[] a, int l, int r) {
        int n = a.length;
        int prev = a[l];
        int prev2 = 0;

        for (int i = 1; i < n - 1; i++) {

            int t = a[l + i];
            if (i > 1)
                t += prev2;
            int nt = prev;
            int cur = Math.max(t, nt);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public int rob(int[] a) {
        int n = a.length;
        if (n == 1)
            return a[0];
        return Math.max(robs(a, 1, n - 1), robs(a, 0, n - 2));
    }
}