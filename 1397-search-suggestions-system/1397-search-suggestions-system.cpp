class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        sort(products.begin(),products.end());
        vector<vector<string>> ans;
        int bstart=0;
        string st ="";
        int start;
        int n = products.size();
        for(char &c: searchWord){
            st+=c;
            start = lower_bound(products.begin()+bstart,products.end(), st)-products.begin();
            ans.push_back({});
            for(int i=start; i<(min(start+3, n)) && !products[i].compare(0,st.length(), st); i++){
                ans.back().push_back(products[i]);
            }
            bstart = start;
        }
        return ans;
    }
};