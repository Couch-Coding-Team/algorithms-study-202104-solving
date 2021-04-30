// 00:13:16
// 테스트 1 〉	통과 (0.01ms, 3.97MB)
// 테스트 2 〉	통과 (0.01ms, 3.93MB)
// 테스트 3 〉	통과 (0.01ms, 3.92MB)
// 테스트 4 〉	통과 (0.05ms, 3.97MB)
// 테스트 5 〉	통과 (0.02ms, 3.98MB)
// 테스트 6 〉	통과 (0.02ms, 3.96MB)
// 테스트 7 〉	통과 (0.02ms, 3.97MB)
// 테스트 8 〉	통과 (0.05ms, 3.82MB)
// 테스트 9 〉	통과 (0.04ms, 3.77MB)
// 테스트 10 〉	통과 (0.04ms, 3.96MB)
// 테스트 11 〉	통과 (0.05ms, 3.94MB)

#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    
    vector<stack<int>> board_stack;
    for (int c = 0; c < board[0].size(); c++) {
        stack<int> st;
        for (int r = board.size() - 1; r >= 0; r--) {
            if (board[r][c] == 0) break;
            st.push(board[r][c]);
        }
        board_stack.push_back(st);
    }
    
    stack<int> bucket;
    
    for (auto idx : moves) {
        idx--;
            
        if (board_stack[idx].empty()) continue;
        
        int target = board_stack[idx].top(); 
        board_stack[idx].pop();
        
        if (bucket.empty()) bucket.push(target);
        else {
            if (bucket.top() == target) {
                bucket.pop();
                answer += 2;
            }
            else bucket.push(target);
        }
    }
    
    return answer;
}
