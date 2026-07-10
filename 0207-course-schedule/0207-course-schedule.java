class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> adj[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        boolean stackArr[] = new boolean[numCourses];
        for (int cource[] : prerequisites) {
            adj[cource[0]].add(cource[1]);
            // adj[cource[1]].add(cource[0]);
        }
        boolean isVis[] = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!isVis[i]) {
                if (checkCycle(i, isVis, adj, stackArr)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkCycle(int src, boolean isVis[], ArrayList<Integer> adj[], boolean stArr[]) {
        isVis[src] = true;
        stArr[src] = true;

        for (int neig : adj[src]) {

            if (isVis[neig] && stArr[neig]) {
                return true;
            }
            if (!isVis[neig])
                if (checkCycle(neig, isVis, adj, stArr)) {
                    return true;
                }
        }
        stArr[src] = false;
        return false;
    }
}