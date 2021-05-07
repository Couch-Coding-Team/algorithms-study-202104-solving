class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {

        vector<vector<int>> answer(people.size(), vector<int>(2, -1));

        // 1. ascending order
        auto comp = [](vector<int>& a, vector<int>& b) {
            if (a[0] == b[0]) return a[1] < b[1];
            return a[0] < b[0];
        };
        sort(people.begin(), people.end(), comp);
        
        // 2. insert people
        for (auto& person : people) {
            int limit = person[1];
            
            for (int i = 0; i < answer.size(); i++) {
                if (answer[i][0] == -1 && limit == 0) {
                    answer[i][0] = person[0];
                    answer[i][1] = person[1];
                    break;
                }
                else {
                    if (answer[i][0] == -1 || answer[i][0] >= person[0]) {
                        limit--;
                    }
                }
            }
        }
        
        return answer;
    }
};
