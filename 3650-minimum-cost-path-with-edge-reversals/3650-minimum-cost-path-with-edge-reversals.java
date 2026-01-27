class Solution {
    static class Edge {
        int to;
        int weight;
        Edge(int t, int w) {
            to = t;
            weight = w;
        }
    }

    static class State {
        int node;
        int used; // 0 = switch not used, 1 = used
        long cost;

        State(int n, int u, long c) {
            node = n;
            used = u;
            cost = c;
        }
    }

    public int minCost(int n, int[][] edges) {

        List<Edge>[] outAdj = new ArrayList[n];
        List<Edge>[] inAdj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            outAdj[i] = new ArrayList<>();
            inAdj[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            outAdj[u].add(new Edge(v, w));
            inAdj[v].add(new Edge(u, w));
        }
        //long INF = (long) 1e18;
        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.cost, b.cost)
        );

        dist[0][0] = 0;
        pq.offer(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            int used = cur.used;
            long cost = cur.cost;

            if (cost > dist[u][used]) continue;

            // 1️⃣ Normal outgoing edges
            for (Edge e : outAdj[u]) {
                int v = e.to;
                long newCost = cost + e.weight;

                if (newCost < dist[v][0]) {
                    dist[v][0] = newCost;
                    pq.offer(new State(v, 0, newCost));
                }
            }

            // 2️⃣ Reverse incoming edges (only if switch not used)
            if (used == 0) {
                for (Edge e : inAdj[u]) {
                    int v = e.to;
                    long newCost = cost + 2L * e.weight;

                    if (newCost < dist[v][0]) {
                        dist[v][0] = newCost;
                        pq.offer(new State(v, 0, newCost));
                    }
                }
            }
        }

        long ans = Math.min(dist[n - 1][0], dist[n - 1][1]);
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}