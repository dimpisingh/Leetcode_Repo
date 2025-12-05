class Solution {
    public int countPartitions(int[] A) {
        int total = 0;
        for (int x : A)
            total += x;
        return (total & 1) == 0 ? A.length - 1 : 0;
    }
}