class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int rem=0;
        int num=x;
        while(num!=0){
            //rem=num%10;
            rem = rem*10+num%10;
            num= num/10;
        }
        return (rem==x);
    }
}