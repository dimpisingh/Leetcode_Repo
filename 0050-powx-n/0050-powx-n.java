class Solution {
    public double myPow(double x, int n) {
    if (n == 0) return 1;
    if (n == 1) return x;

    long N = n; // Use long to avoid overflow when n = -2147483648
    if (N < 0) {
        x = 1 / x;
        N = -N;
    }

    double result = 1.0;
    while (N > 0) {
        if ((N % 2) == 1) { // If N is odd
            result *= x;
        }
        x *= x; // Square the base
        N /= 2; // Divide N by 2
    }

    return result;
}

}