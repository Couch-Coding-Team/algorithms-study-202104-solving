class Solution {
    unordered_map<string, bool> m; 
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        
        if (m.find(s) != m.end()) return m[s];
        
        bool answer = false;
                
        for (auto w : wordDict) {
            int len = w.length();

            if (w == s.substr(0, len)) {

                if (len == s.length()) answer = true;
                else answer |= wordBreak(s.substr(len), wordDict);
            }
            
            if (answer) break;
        }
        
        m.insert({s, answer});
        return answer;
    }
};
