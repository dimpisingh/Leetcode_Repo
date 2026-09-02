class Solution {
public:
    bool uniformArray(vector<int>& nums1) {
        int i=0,j=0;
        bool ans = true;
        for(i;i<nums1.size(); i++){
            if(nums1[i]%2==0){
                continue;
            }
            else {
                nums1[i]-nums1[j];
                j++;
            }
        }
        return true;
    }
};