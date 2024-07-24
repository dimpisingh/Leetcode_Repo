class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.size() == 0) return 0;
        unordered_map<char, int> mp;
        int n = s.size();
        int i = 0, len = 0;
        int j = 0;
        while (j < n) {
            if (mp.find(s[j]) != mp.end()) {
                i = max(mp[s[j]] + 1, i);
            }
            mp[s[j]] = j;
            len = max(len, j - i + 1);
            j++;
        }
        return len;
    }
};