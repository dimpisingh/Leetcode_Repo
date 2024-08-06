class Solution {
public:
    vector<vector<int>> reconstructMatrix(int u, int l, vector<int>& c) {

        vector<vector<int>> ans;
// sum all elements in colsum vector and count no of 2's present in colsum;
// if sum is not equal to lower + upper or if no of 2's is greater than lower than return empty vector.
        int cs=0; int cnt2=0;
        for(int i=0; i<c.size(); i++){
           cs+=c[i]; 
           if(c[i]==2) cnt2++;
        }       
        if(cs != u+l || l<cnt2) return ans;
//create two vector for upper and lower row. Initialize them with zero;
        int n=c.size();
        vector<int> v1(n,0);
        vector<int> v2(n,0);
//if column sum for any matrix cell is 2, we will assign them 1. Since for column sum =2, we need 1 in both upper and lower row for that column
        for(int i=0; i<n; i++){
            if(c[i]==2){
                v1[i]=1;
                u--; c[i]--;
            }
        }     
//For upper row, if upper sum>0 and colsum> 0, assign it with 1; Repeat same for lower vector too
         for(int i=0; i<n; i++){
            if(u && c[i] && !v1[i]){
                v1[i]=1;
                u--; c[i]--;
            }
        }
        for(int i=0; i<n; i++){
            if(l && c[i]){
                v2[i]=1;
                l--; c[i]--;
            }
        }
        ans.push_back(v1);
        ans.push_back(v2);
     return ans;
    }
};