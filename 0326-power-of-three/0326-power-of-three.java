class Solution {
    private static int findSum(int n){
        int sum =0 ;
        while(n>0){
            int r = n%10;
            sum+=r;
            n=n/10;
        }
        return sum;
    }
    public boolean isPowerOfThree(int n) {
        int maxPowerOf3 = 1162261467;
        return n > 0 && maxPowerOf3 % n == 0;
    }
}