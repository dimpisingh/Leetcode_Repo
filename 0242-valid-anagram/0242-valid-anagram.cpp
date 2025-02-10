class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> mp;
        unordered_map<char, int> tp;
        if (t.size() != s.size())
            return false;
        for (int i = 0; i < s.size(); i++) {
            mp[s[i]]++;
        }
        for (int j = 0; j < t.size(); j++) {
            tp[t[j]]++;
        }
        for (int i = 0; i < s.size(); i++) {
            if (mp[s[i]] != tp[s[i]])
                return false;
        }
        return true;
    }
};