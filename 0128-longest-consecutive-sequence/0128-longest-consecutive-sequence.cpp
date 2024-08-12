class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) {
            return 0;
        }
        unordered_set<int> st(nums.begin(), nums.end());

        int longest = 1;

        for (int num : nums) {
            if (st.find(num - 1) == st.end()) { // Start of a new sequence
                int cnt = 1;
                int x = num;
                while (st.find(x + 1) != st.end()) {
                    x = x + 1;
                    cnt += 1;
                }
                longest = max(longest, cnt);
            }
        }
        return longest;
    }
};