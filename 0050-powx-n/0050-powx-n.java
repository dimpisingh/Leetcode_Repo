class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        // T.C O(logn) S.C O(1)
        // long N = n; // Use long to avoid overflow when n = -2147483648
        // if (N < 0) {
        // x = 1 / x;
        // N = -N;
        // }
        double result = 1.0;
        // while (N > 0) {
        // if ((N % 2) == 1) { // If N is odd
        // result *= x;
        // }
        // x *= x; // Square the base
        // N /= 2; // Divide N by 2
        // }
        // return result;

        // T.C O(log n) S.C O(1)
        long N = n; //Convert n to long to handle the overflow issue
        if (N < 0) {
            N = -N; // Make n positive
        }
        while (N > 0) {
            if (N % 2 == 1) {
                result *= x;
                N--;
            } else {
                x *= x;
                N = N / 2;
            }
        }
        if (n < 0)
        result = (double) (1.0) / (double) (result);
        return result;
    }

}