class Solution {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Info {
        int vertix;
        int cost;
        int stop;

        public Info(int v, int c, int s) {
            this.vertix = v;
            this.cost = c;
            this.stop = s;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int flight[] : flights) {
            int src = flight[0];
            int dest = flight[1];
            int wt = flight[2];
            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src)
                dist[i] = Integer.MAX_VALUE;
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stop > k)
                break;

            for (Edge e : graph[curr.vertix]) {
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.stop <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stop + 1));
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dst];
        }
    }
}