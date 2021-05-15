/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var findTargetSumWays = function(nums, target) {
    let dp = [];
    
    let res = 0;
    
    function dfs(nums, i,sum, len){
        if(i === len){
            if(sum === target){
                res++;
                return 1;
            }
            return 0;
        }

        dfs(nums, i+1, sum + nums[i], len);
        dfs(nums, i+1, sum - nums[i], len);
    }
    
    dfs(nums, 0, res, nums.length)
    return res;
}
