
class Solution {
public:
    int maxArea(vector<int>& a) {
        int n = a.size();
        int res = 0, area = 0;
        int i = 0;
        int j = n - 1;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         left = min(a[j], a[i]);
        //         area = (j - i) * left;
        //         res = max(res, area);
        //     }
        // }
        while (i <= j) {
            area = (j - i) * min(a[i], a[j]);
            res = max(area, res);
            if (a[i] < a[j])
                i++;
            else
                j--;
        }
        return res;
    }
};