class Solution {
    // private static int helper(int n, int dp[]){
    //     if(n == 0 ) return 1;
    //     if(n < 0) return 0;

    //     if(dp[n] != -1){
    //         return dp[n];
    //     }
    //     dp[n] = helper(n-1, dp) + helper(n-2, dp);  
    //     return dp[n];
    // }
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            if(i == 1){
                dp[i] = dp[i-1] + 0;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}