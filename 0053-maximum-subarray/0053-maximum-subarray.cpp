class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = INT_MIN;
        int Csum = 0;
        for (int num : nums) {
            if (Csum < 0) {
                Csum = 0; // Reset the sum if it's negative
            }
            Csum += num;
            sum = max(sum, Csum);
        }
        return sum;
    }
};