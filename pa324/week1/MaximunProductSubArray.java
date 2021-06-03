class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int maxNum = nums[0];
        int minNum = nums[0];
        // 음수 * 음수인경우가 최대가될수 있으므로 최소값도 같이 체크
        for(int i = 1; i < nums.length; i++) {
            int temp = maxNum;
            maxNum = Math.max(Math.max(nums[i]*maxNum,nums[i]*minNum),nums[i]);
            minNum = Math.min(Math.min(nums[i] * temp, nums[i] * minNum ),nums[i]);
            result = Math.max(result,maxNum);
        }
        
        return result;
    }
}
