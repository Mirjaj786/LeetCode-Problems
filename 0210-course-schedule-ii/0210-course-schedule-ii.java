class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int ans[] = new int[numCourses];
        boolean isVis[] = new boolean[numCourses];
        ArrayList<Integer> adj[] = new ArrayList[numCourses];
        Stack<Integer> s = new Stack<>();
        boolean stackArr[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int course[] : prerequisites) {
            adj[course[1]].add(course[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!isVis[i]) {
                if (dfs(i, isVis, adj, s, stackArr)) {
                    return new int[0];
                }

            }
        }

        int i = 0;
        while (!s.isEmpty()) {

            ans[i] = s.pop();
            i++;
        }
        return ans;
    }

    private boolean dfs(int src, boolean isVis[], ArrayList<Integer> adj[], Stack<Integer> s, boolean sarr[]) {
        isVis[src] = true;
        sarr[src] = true;
        for (int nei : adj[src]) {
            if (!isVis[nei]) {
                if (dfs(nei, isVis, adj, s, sarr)) {
                    return true;
                }
            } else if (sarr[nei]) {
                return true;
            }
        }
        s.push(src);
        sarr[src] = false;
        return false;
    }
}