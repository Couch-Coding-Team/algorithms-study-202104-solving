class P746_Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < N; i++){
            dp[i] = Math.min(dp[i-2], dp[i-1]) + cost[i];
        }
        return Math.min(dp[N-1], dp[N-2]);
    }
}