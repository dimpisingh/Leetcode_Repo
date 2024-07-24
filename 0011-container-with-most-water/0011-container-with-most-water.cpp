class Solution {
public:
    int maxArea(vector<int>& a) {
        int n = a.size();
        int res = 0, area = 0, left;
        left = 0;
        int right = n-1;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         left = min(a[j], a[i]);
        //         area = (j - i) * left;
        //         res = max(res, area);
        //     }
        // }
        while(left <= right){
            area = (right - left)* min(a[left], a[right]);
            res = max(area, res);
            if(a[left] < a[right]) 
            left++;
            else right --;
        }
        return res;
    }
};