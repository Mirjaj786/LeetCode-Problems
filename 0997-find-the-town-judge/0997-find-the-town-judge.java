class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n <= 1){
            return n;
        }
        int indeg[] = new int[n+1];
        int outdeg[] = new int[n+1];
        for(int t[] : trust){
            int src = t[0];
            int dest = t[1];
            outdeg[src]++;
            indeg[dest]++;
        }

        for(int i=0; i<=n; i++){
            if(indeg[i] == n-1 && outdeg[i] == 0){
                return i;
            }
        }
        return -1;
    }
}