class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        findCombo(candidates, target, 0);
        return ans;
    }
private:
    vector<vector<int>> ans;
    vector<int> ds;
    void findCombo(vector<int>& nums, int ta, int i) {
        if (i >= nums.size() || ta < 0)
            return;
        if (ta == 0) {
            ans.push_back(ds);
            return;
        }
        ds.push_back(nums[i]);
        findCombo(nums, ta - nums[i], i);
        ds.pop_back();
        findCombo(nums, ta, i + 1);
    }
};