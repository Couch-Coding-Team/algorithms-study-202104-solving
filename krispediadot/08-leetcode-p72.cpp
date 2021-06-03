class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int>> dp(word1.length() + 1, vector<int> (word2.length() + 1, 0));
        
        for (int r = 0; r <= word1.length(); r++) dp[r][0] = r;
        for (int c = 0; c <= word2.length(); c++) dp[0][c] = c;
        
        for (int r = 1; r <= word1.length(); r++) {
            for (int c = 1; c <= word2.length(); c++) {      

                dp[r][c] = min(dp[r-1][c-1] + (word1[r-1] == word2[c-1] ? 0 : 1), min(dp[r-1][c] + 1, dp[r][c-1] + 1));
                
            }
        }
        
        return dp[word1.length()][word2.length()];
    }
};
