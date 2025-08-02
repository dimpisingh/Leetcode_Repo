class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        
        int reversedNumber = 0;
        int x2 = x;
        while (x != 0) {
            int digit = x % 10;
            reversedNumber = reversedNumber * 10 + digit;
            x /= 10;
        }
        if (x2 == reversedNumber)
            return true;
        else
            return false;
    }
}