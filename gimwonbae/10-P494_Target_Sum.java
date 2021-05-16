class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2001];
        dp[0][1000 - nums[0]] = 1;
        dp[0][1000 + nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 2001; j++) {
                if (dp[i - 1][j] > 0) {
                    dp[i][j + nums[i]] += dp[i - 1][j];
                    dp[i][j - nums[i]] += dp[i - 1][j];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][1000 + S];
    }
}
