// 0ms, 7.5MB, 00:02:20
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> answer;
        
        sort(nums.begin(), nums.end());
        
        do {
            answer.push_back(nums);
        } while (next_permutation(nums.begin(), nums.end()));
    
        return answer;
    }
};

// 0ms, 9.1MB
class Solution2 {
    vector<vector<int>> answer;
public:
    void generator(vector<int> unique_set, vector<int> temp) {
        if (unique_set.size() == 0) {
            answer.push_back(temp);
            return;
        }

        for (auto target : unique_set) {
            vector<int> unique_set_copy = unique_set;
            unique_set_copy.erase(find(unique_set_copy.begin(), unique_set_copy.end(), target));
            temp.push_back(target);
            generator(unique_set_copy, temp);
            temp.pop_back();
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<int> unique_set(nums.begin(), nums.end());

        vector<int> temp;
        generator(unique_set, temp);

        return answer;
    }
};
