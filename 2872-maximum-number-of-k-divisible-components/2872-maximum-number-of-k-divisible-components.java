class Solution {
    int ans = 0;
    int k;

    long dfs(int node, int parent, List<List<Integer>> adj, int[] values) {
        long sum = values[node];

        for (int nei : adj.get(node)) {
            if (nei == parent)
                continue;
            sum += dfs(nei, node, adj, values);
        }

        if (sum % k == 0) {
            ans++;
            return 0;
        }

        return sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        dfs(0, -1, adj, values);
        return ans;
    }

}
