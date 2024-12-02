class Solution {
public:
    int count = 0;
    void dfs(int u, int p, unordered_map<int, vector<vector<int>>>& adj) {
        for (auto& a : adj[u]) {
            int v = a[0];
            int check = a[1];
            if (v != p) {
                if (check == 1) {
                    count++;
                }
                dfs(v, u, adj);
            }
        }
    }
    int minReorder(int n, vector<vector<int>>& connections) {
        unordered_map<int, vector<vector<int>>> adj;
        for (vector<int> v : connections) {
            int a = v[0];
            int b = v[1];
            adj[a].push_back({b, 1});
            adj[b].push_back({a, 0});
        }
        dfs(0, -1, adj);
        return count;
    }
};