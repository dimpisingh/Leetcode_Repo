class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int xr1 = 0, xr2 = 0;
        for (int i = 0; i <= nums.size(); i++) {
            xr1 ^= i;
        }
        for (int i = 0; i < nums.size(); i++) {
            xr2 = xr2 ^ nums[i];
        }
        return xr1 ^ xr2;
    }
};