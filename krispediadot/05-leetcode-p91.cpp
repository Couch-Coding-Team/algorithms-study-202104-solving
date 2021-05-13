class Solution {
    vector<int> dp;
public:
    int numDecodings(string s) {
        if (dp.size() == 0) {
            dp.resize(s.length() + 1, -1);
            dp[s.length()] = 1;
        }
        
        int idx = dp.size() - s.length() - 1;
        
        if (dp[idx] != -1) return dp[idx];
        if (s.length() == 0) return 0;
        if (s[0] == '0') return dp[idx] = 0;
        if (s.length() == 1) return dp[dp.size() - 2] = 1;
        
        dp[idx] = numDecodings(s.substr(1));

        if ((s[0] == '2' && s[1] <= '6') || s[0] == '1') 
            dp[idx] += numDecodings(s.substr(2));

        return dp[idx];
    }
};
