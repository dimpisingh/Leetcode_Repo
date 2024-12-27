class Solution {
public:
    int climbStairs(int n) {
        int* memo = new int[n + 1]();
        int result = helper(n, memo);
        delete[] memo; // Free the dynamically allocated memory
        return result;
    }

    int helper(int n, int memo[]) {
        if (n == 1 || n == 2)
            return n;
        if (memo[n] != 0)
            return memo[n];
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }
};