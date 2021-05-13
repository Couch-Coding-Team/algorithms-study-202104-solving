class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int answer = nums[0];
        
        for (int idx = 1; idx < nums.size(); idx++) {
            nums[idx] = max(nums[idx - 1] + nums[idx], nums[idx]);
            
            answer = max(answer, nums[idx]);
        }
        
        return answer;
    }
};
