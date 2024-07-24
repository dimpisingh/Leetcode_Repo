#pragma GCC optimize("O3,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")
static const bool Booster = [](){ std::ios_base::sync_with_stdio(false); std::cin.tie(nullptr); std::cout.tie(nullptr); return true;}();inline bool is_digit(char c) { return c >= '0' && c <= '9';}std::array<int, 100000> nums;void parse_input_and_solve(std::ofstream& out, const std::string& s) { const int N = s.size(); int left = 0; int idx = 0; while (left < N) { if (!is_digit(s[left])) { ++left; continue; } int right = left; int value = 0; while (right < N && is_digit(s[right])) { value = value * 10 + (s[right] - '0'); ++right; } left = right; nums[idx] = value; ++idx; }  int area = 0, i = 0, j = idx-1; label:  area = max(area, (j-i)*min(nums[i], nums[j])); if(nums[i] < nums[j]) i++; else j--; if(i < j) goto label; out<<area<<"\n";}bool Solve = [](){ std::ofstream out("user.out"); for (std::string s; std::getline(std::cin, s);) { parse_input_and_solve(out, s); } out.flush(); exit(0); return true;}();

class Solution {
public:
    int maxArea(vector<int>& a) {
        int n = a.size();
        int res = 0, area = 0, left;
        left = 0;
        int right = n - 1;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         left = min(a[j], a[i]);
        //         area = (j - i) * left;
        //         res = max(res, area);
        //     }
        // }
        while (left <= right) {
            area = (right - left) * min(a[left], a[right]);
            res = max(area, res);
            if (a[left] < a[right])
                left++;
            else
                right--;
        }
        return res;
    }
};