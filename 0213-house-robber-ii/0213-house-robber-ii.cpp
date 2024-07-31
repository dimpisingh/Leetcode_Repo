class Solution {
public:
    int rob(vector<int>& nums) {
        vector<int> nums1(nums.begin() + 1, nums.end());
        vector<int> nums2(nums.begin(), nums.end() - 1);
        return max(nums[0], max(helper(nums1), helper(nums2)));
    }

    int helper(vector<int>& nums) {
        int r1 = 0, r2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            i = i % nums.size();
            int tmp = max(nums[i] + r1, r2);
            r1 = r2;
            r2 = tmp;
        }
        return r2;
    }
};