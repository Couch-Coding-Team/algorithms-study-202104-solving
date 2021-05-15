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
