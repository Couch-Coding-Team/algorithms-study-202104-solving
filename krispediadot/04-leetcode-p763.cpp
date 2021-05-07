
class Solution {
public:
    vector<int> partitionLabels(string S) {
        vector<int> last_loc(26, -1);
        vector<int> answer;
        
        // 1. get last location
        for (int idx = 0; idx < S.length(); idx++) 
            last_loc[S[idx] - 'a'] = idx;
        
        // 2. partition
        int start = 0, end = -1;
        for (int idx = 0; idx < S.length(); idx++) {
            char target = S[idx]; 
            
            end = max(end, last_loc[target - 'a']);
            
            if (idx == end) {
                answer.push_back(end - start + 1);
                start = end + 1;
                end = -1;
            }
        }
        
        return answer;
    }
};
