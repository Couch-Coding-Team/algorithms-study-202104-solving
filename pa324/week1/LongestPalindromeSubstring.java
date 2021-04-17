class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        String result = "";
        int start = 0;
        int end = 0;
        int [][] dp = new int[length][length];
        for(int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for(int i = 0; i < length - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 2;
                start = i;
                end = i+1;
            }
        }
        for(int len = 3; len <= length; len++) {
            for(int i = 0,j = i + len - 1; j < s.length(); i++,j++) {
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] != 0) {
                    dp[i][j] = s.substring(i,j+1).length();
                    if(result.length() < s.substring(i,j+1).length()) {
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start,end+1);
    }
}
