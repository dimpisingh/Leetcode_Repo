class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;
            int s = bitA + bitB + carry;
            sum.append(s % 2);
            carry = s / 2;
            i--;
            j--;
        }
        return sum.reverse().toString();
    }
}