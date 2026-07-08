class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        

        for(int i=0; i<color.length; i++){
            color[i] = -1;
        }

        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                if(!bfs(i, color, graph)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int src, int col[], int graph[][]){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        col[src] = 0;

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " -> ");

            for(int j=0; j<graph[curr].length; j++){
                int nei = graph[curr][j];
                System.out.print(nei);
                if(col[nei] == -1){
                    col[nei] = 1 - col[curr];
                    q.add(nei);
                }else if(col[nei] == col[curr]){
                    return false;
                }
                System.out.println();
            }
        }
        return true;
    }
}