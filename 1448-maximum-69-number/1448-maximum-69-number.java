class Solution {
    public int maximum69Number(int num) {
        int num1 = num, ind6 = -1, rem = 0, pos = 0;
        while (num1 > 0) {
            rem = num1 % 10;
            if (rem == 6) {
                ind6 = pos;
            }
            pos++;
            num1 = num1 / 10;
        }
        if (ind6 == -1)
            return num;
        else
            return (num + 3 * (int) Math.pow(10, ind6));
    }
}