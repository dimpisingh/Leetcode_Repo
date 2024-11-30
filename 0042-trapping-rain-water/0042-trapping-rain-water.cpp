class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        vector<int> lmax;
        vector<int> rmax(n);
          if (n == 0) return 0;
        lmax.push_back(height[0]);
        rmax[n-1]=height[n - 1];
        for (int i = 1; i < n; i++) {
            if (lmax[i - 1] < height[i]) {
                lmax.push_back(height[i]);
            } else
                lmax.push_back(lmax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            if (rmax[i + 1] < height[i]) {
                rmax[i] = height[i];
            } else
                rmax[i] = rmax[i + 1];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += min(lmax[i], rmax[i]) - height[i];
        }
        return ans;
    }
};