class P91_Decode_Ways {
    static int[] dp;
    public int numDecodings(String s) {
        int N = s.length();
        dp = new int[N];

        int first = s.charAt(0) - '0';
        if (first == 0) dp[0] = 0;
        else dp[0] = 1;

        int second;
        if (N >= 2){
            second = s.charAt(1) - '0';
            if (second != 0) dp[1] = dp[0];
            else if (first != 1 && first != 2) return 0;
            int number = first * 10 + second;
            if (10 <= number && number <= 26) dp[1] += 1;
        }
        else return dp[0];
        first = second;

        for (int i = 2; i < N; i++){
            second = s.charAt(i) - '0';
            if (second != 0) dp[i] = dp[i-1];
            else if (first != 1 && first != 2) return 0;
            int number = first * 10 + second;
            if (10 <= number && number <= 26) dp[i] += dp[i-2];
            first = second;
        }
        return dp[N-1];
    }
}