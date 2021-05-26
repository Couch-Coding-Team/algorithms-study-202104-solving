// 0ms, 6.8MB, 00:16:00
class Solution {
    vector<vector<string>> keys = {{},
                                 {},
                                 {"a", "b", "c"},
                                 {"d", "e", "f"},
                                 {"g", "h", "i"},
                                 {"j", "k", "l"},
                                 {"m", "n", "o"},
                                 {"p", "q", "r", "s"},
                                 {"t", "u", "v"},
                                 {"w", "x", "y", "z"}
                                };
public:
    vector<string> letterCombinations(string digits) {
        vector<string> answer;
        
        for (auto c : digits) {
            
            vector<string> answer_prev = answer;
            answer.clear();
            
            for (auto target : keys[c - '0']) {
                if (answer_prev.size() == 0) answer.push_back(target);
                for (auto prev : answer_prev) {
                    answer.push_back(prev + target);
                }
            }
        }
        
        return answer;
    }
};
