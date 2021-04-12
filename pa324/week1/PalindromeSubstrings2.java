class Solution {
  public int countSubstrings(String s) {
    if(s.length() == 0) {
      return 0;
    }
    int length = s.length();
    boolean [][] dp = new boolean[length][length];
    int count = 0;
    for(int i = 0; i < length; i++) {
      dp[i][i] = true;
      count++;
    }
    for(int i = 0; i < length-1; i++) {
      dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
      if(dp[i][i+1]) {
        count++;
      }
    }
    for(int len = 3; len <= s.length(); len++) {
      for(int i = 0,j = i+len-1; j<s.length(); i++,j++){
        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
        if(dp[i][j]) {
          count++;
        }
      }
    }
    return count;
  }

}
