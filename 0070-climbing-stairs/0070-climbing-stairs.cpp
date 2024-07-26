class Solution {
public:
    int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int res;
        int first = 1, second = 2;
        for (int i = 2; i < n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
};