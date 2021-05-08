class Solution1 {
public:
    bool canJump(vector<int>& nums) {
        vector<bool> able(nums.size(), false);
        able[nums.size() - 1] = true;
        
        for (int idx = nums.size() - 1; idx >= 0; idx--) {
            int term = nums[idx];
            
            for (int t = 1; t <= term; t++) {
                if (idx + t < nums.size() && able[idx + t] == true) {
                    able[idx] = true;
                    break;
                }
            }
        }
        
        return able[0];
    }
};
class Solution2 {
public:
    bool canJump(vector<int>& nums) {
        int last = nums.size() - 1;
        
        for (int idx = nums.size() - 1; idx >= 0; idx--) {
            if (idx + nums[idx] >= last) {
                last = idx;
            }
        }
        
        return last == 0;
    }
};
