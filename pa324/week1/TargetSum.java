class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,0,target);
    }
    private int dfs(int [] nums, int depth, int target) {
        if(depth == nums.length) {
            if(target == 0) {
                return 1;
            }
            return 0;
        }
        return dfs(nums,depth+1,target-nums[depth]) 
            + dfs(nums,depth+1,target+nums[depth]);
    }
}
