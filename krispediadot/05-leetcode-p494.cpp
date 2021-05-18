class Solution {
public:
    void calcNums(vector<int>& nums, int idx, int sum, int target, int& answer) {
        if (idx == nums.size()) {
            if (sum == target) answer++;
            return;
        }
        
        // +
        calcNums(nums, idx + 1, sum + nums[idx], target, answer);
        
        // - 
        calcNums(nums, idx + 1, sum - nums[idx], target, answer);
    }
    
    int findTargetSumWays(vector<int>& nums, int target) {
        int answer = 0;
        
        calcNums(nums, 0, 0, target, answer);
        
        return answer;
    }
};

class Solution2 {
    vector<vector<int>> dp;
public:
    int calcNums(vector<int>& nums, int idx, int sum, int target) {
        if (idx == nums.size()) return sum == target ? 1 : 0;
        if (dp[idx][sum + 1000] != -1) return dp[idx][sum + 1000];

        int cnt = 0;

        // +
        cnt += calcNums(nums, idx + 1, sum + nums[idx], target);

        // -
        cnt += calcNums(nums, idx + 1, sum - nums[idx], target);

        return dp[idx][sum + 1000] = cnt;
    }

    int findTargetSumWays(vector<int>& nums, int target) {
        dp.resize(21, vector<int>(2001, -1));
        return calcNums(nums, 0, 0, target);
    }
};
