class Solution {
    public int maximumProduct(int[] nums) {
        if (nums.length == 3)
            return nums[0] * nums[1] * nums[2];
        int mx1 = Integer.MIN_VALUE, mx2 = Integer.MIN_VALUE, mx3 = Integer.MIN_VALUE;
        int mn1 = Integer.MAX_VALUE, mn2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > mx1) {
                mx3 = mx2;
                mx2 = mx1;
                mx1 = n;
            } else if (n > mx2) {
                mx3 = mx2;
                mx2 = n;
            } else if (n > mx3)
                mx3 = n;
            if (n < mn1) {
                mn2 = mn1;
                mn1 = n;
            } else if (n < mn2) {
                mn2 = n;
            }
        }

        return Math.max(mx1 * mx2 * mx3, mn1 * mn2 * mx1);
    }
}