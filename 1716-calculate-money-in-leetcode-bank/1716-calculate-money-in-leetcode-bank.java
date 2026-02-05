class Solution {
    public int totalMoney(int n) {
        int r = 0, q = 0, sum = 0;
        q = n / 7;
        r = n % 7;
        sum = 28 * q + 7 * q * (q - 1) / 2 + (2 * q + r + 1) * r / 2;
        return sum;

    }
}