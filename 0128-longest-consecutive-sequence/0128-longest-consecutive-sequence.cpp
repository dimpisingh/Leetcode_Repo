class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) {
            return 0;
        }
        unordered_set<int> st(nums.begin(),nums.end());
        //int cnt = 1;
        int longest = 1;
        int longestStreak=0;
        for (int num : nums) {
        if (st.find(num - 1) == st.end()) { // Start of a new sequence
            longestStreak =0 ;
            while (st.find(num + longestStreak) != st.end()) {
                //cnt += 1;
                longestStreak += 1;
                
            }
            longest = max(longest, longestStreak);        
        }
        
        }
        return longest;
    }

    

    
    
};