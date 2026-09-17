class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];

        for(int i=0; i<n; i++){
            dp1[i] = -1;
            dp2[i] = -1;
        }

        return Math.max(nums[0] + help(2, n-1, dp1, nums), help(1, n, dp2, nums)); 
    }

    private static int help(int i, int size, int dp[], int arr[]){
        if( i >= size){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int take = arr[i] + help(i+2, size, dp, arr);
        int notTake = help(i+1, size, dp, arr);
        int mx =  Math.max(take, notTake);
        dp[i] = mx;
        return mx;
    }
}