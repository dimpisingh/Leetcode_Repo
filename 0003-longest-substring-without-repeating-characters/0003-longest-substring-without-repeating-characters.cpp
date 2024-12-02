class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.size() == 0)
            return 0;
        unordered_map<char, int> mp;
        int l = 0, r = 0;
        int len = 0;
        while (r < s.size()) {
            if (mp.find(s[r]) != mp.end()) {
                if (mp[s[r]] >= l) {
                    l = mp[s[r]] + 1;
                }
            }
            mp[s[r]] = r;
            len = max(len, r - l + 1);
            r++;
        }
        return len;
    }
};