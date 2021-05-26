// 0ms, 14.2MB, 00:53:10
class Solution {
public:
    int trap(vector<int>& height) {
        
        if (height.size() == 0) return 0;
        
        int answer = 0;
        
        int cur_max = height[0];
        int temp = 0;
        
        for (int i = 1; i < height.size(); i++) {
            if (height[i] >= cur_max) {
                answer += temp;
                cur_max = height[i];
                
                temp = 0;
            }
            else temp += (cur_max - height[i]);
        }
        
        cur_max = height.back();
        temp = 0;
        
        for (int i = height.size() - 1; i >= 0; i--) {
            if (height[i] > cur_max) {
                answer += temp;
                cur_max = height[i];
                
                temp = 0;
            }
            else temp += (cur_max - height[i]);
        }
        
        return answer;
    }
};
