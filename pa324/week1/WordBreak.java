class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        //s의 i번째 문자까지 break되는지 저장
        //leetcode라는 s와 ["leet","code"]라는 wordDict가 있다면
        //dp[3] = true -> "leetcode"라는 문자열의 leet는 wordDict에 포함
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        
        for(int i=1;i<=n;i++){ 
            for(int j=0;j<i;j++){ 
                if(dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i]=true;
                    break;
                }
            }
        }
        
        return dp[n];
           
    }
}
