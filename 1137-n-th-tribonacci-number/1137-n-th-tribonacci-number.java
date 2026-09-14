class Solution {
    public int tribonacci(int n) {
        int dp[] = new int[n + 1];
        return help(n, dp);
    }

    public int help(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2)
            return 1;

        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = help(n - 1, dp) + help(n - 2, dp) + help(n - 3, dp);
        return dp[n];
    }
}