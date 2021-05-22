class Solution {
public:
    bool check(vector<vector<char>>& board, pair<int, int> cur, string word, int target_idx) {
        if (target_idx >= word.length()) return true;
        if (cur.first < 0 || cur.first >= board.size() || cur.second < 0 || cur.second >= board[0].size() || board[cur.first][cur.second] != word[target_idx])
            return false;

        board[cur.first][cur.second] -= 30;

        if (check(board, {cur.first - 1, cur.second}, word, target_idx + 1) || check(board, {cur.first + 1, cur.second}, word, target_idx + 1) || check(board, {cur.first, cur.second - 1}, word, target_idx + 1) || check(board, {cur.first, cur.second + 1}, word, target_idx + 1))
            return true;

        board[cur.first][cur.second] += 30;
        return false;
    }
    
    bool exist(vector<vector<char>>& board, string word) {
        bool answer = false;
        
        for (int r = 0; r < board.size(); r++) {
            for (int c = 0; c < board[0].size(); c++) {
                if (board[r][c] == word[0]){
                    answer = check(board, {r, c}, word, 0);
                
                    if (answer) return answer;
                }
            }
        }
        
        return answer;
    
