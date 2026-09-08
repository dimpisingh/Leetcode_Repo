class Solution {
    public int countCommas(int n) {

        if (n < 1000)
            return 0;
        // count++;
        int tmp = n;
        // while(n>1000){
        //     //count++;
        //     r=n%1000;
        //     count+=r;
        //     n=n%1000;
        // }
        return tmp - 999;
    }
}