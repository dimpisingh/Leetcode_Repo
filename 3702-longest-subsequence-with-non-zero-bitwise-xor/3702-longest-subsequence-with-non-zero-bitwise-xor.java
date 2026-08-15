class Solution {
    public int longestSubsequence(int[] nums) {
        int result = 0;
        int n = nums.length;
        boolean allZero = true;
        for (int i = 0; i < n; i++) {
            result = nums[i] ^ result;
            if (nums[i] != 0)
                allZero = false;

        }
        if (allZero)
            return 0;
        return result == 0 ? n - 1 : n;
    }
}