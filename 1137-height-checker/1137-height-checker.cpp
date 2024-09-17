class Solution {
public:
    int heightChecker(vector<int>& heights) {
        int n = heights.size();
        int mx = 0;

        int freq[101];
        for (int i = 0; i < 101; i++) {
            freq[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            freq[heights[i]]++;
        }
        int j = 1, ans = 0;
        // int exp[n];
        for (int i = 0; i < n; i++) {

            while (freq[j] == 0)
                j++;
            if (heights[i] == j)
                freq[j]--;
            else {
                ans++;
                freq[j]--;
            }
        }

        return ans;
    }
};