class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans = 0, tmp = INT_MAX, profit = 0;
        for (int i = 0; i < prices.size(); i++) {
            tmp = min(tmp, prices[i]);
            profit = prices[i] - tmp;
            ans = max(ans, profit);
        }
        return ans;
    }
};