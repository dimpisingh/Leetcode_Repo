class Solution {
public:
    bool uniformArray(vector<int>& nums) {
        bool ans = true;
        int oddP = INT_MAX, evenP = 0;
        bool cntO = false, cntE = false;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] % 2 != 0) {
                oddP = min(nums[i], oddP);
                cntO = true;
                ;
            } else
                cntE = true;
        }
        if (!cntO || !cntE)
            return true;
        for (int x : nums) {
            if (x % 2 == 0 && x < oddP)
                return false;
        }

        return true;
    }
};