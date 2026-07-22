class Solution {
    static int time = 0;

    private static void dfs(ArrayList<Integer> adj[], int curr, int par, int dt[], int low[],
            boolean isVis[], List<List<Integer>> ans) {
        isVis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (int nei : adj[curr]) {
            if (par == nei)
                continue;
            else if (!isVis[nei]) {
                dfs(adj, nei, curr, dt, low, isVis, ans);
                low[curr] = Math.min(low[curr], low[nei]);
                if (dt[curr] < low[nei]) {
                    List<Integer> con = new ArrayList<>();
                    con.add(curr);
                    con.add(nei);
                    ans.add(con);
                }

            } else {
                low[curr] = Math.min(low[curr], dt[nei]);
            }
        }

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> adj[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        int dt[] = new int[n];
        int low[] = new int[n];
        boolean isVis[] = new boolean[n];
        for(int i=0; i<connections.size(); i++){
            List<Integer> conn = connections.get(i);
            int u = conn.get(0);
            int v = conn.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 0; i < n; i++) {
            if (!isVis[i]) {
                dfs(adj, i, -1, dt, low, isVis, ans);
            }
        }
        return ans;

    }
}