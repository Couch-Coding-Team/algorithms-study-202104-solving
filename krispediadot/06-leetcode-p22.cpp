// 0ms, 13.7 MB, 01:30:23
class Solution {
public:
    void generator(vector<string>& answer, string s, int open_cnt, int close_cnt, int n) {
        if (close_cnt > open_cnt) return;
        
        if (open_cnt == n && close_cnt == n) {
            answer.push_back(s);
            return;
        }
        
        if (open_cnt < n) {
            generator(answer, s + '(', open_cnt + 1, close_cnt, n);
        }
        if (close_cnt < n) {
            generator(answer, s + ')', open_cnt, close_cnt + 1, n);
        }
    }
    vector<string> generateParenthesis(int n) {
        vector<string> answer;
        
        generator(answer, "", 0, 0, n);
        
        return answer; 
    }
};
