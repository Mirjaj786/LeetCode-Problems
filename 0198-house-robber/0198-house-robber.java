class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return help(nums, dp, n);
    }

    private int help(int nums[], int dp[], int n) {
        if (n == 0)
            return 0; // no house left to rob
        if (n == 1)
            return nums[0]; // only one house rob this house

        if (dp[n] != -1) {
            return dp[n];
        }
         // Include current house
        int val1 = nums[n - 1] + help(nums, dp, n - 2);

         // Exclude current house
        int val2 = help(nums, dp, n - 1); 

        dp[n] = Math.max(val1, val2);
        return dp[n];
    }
}