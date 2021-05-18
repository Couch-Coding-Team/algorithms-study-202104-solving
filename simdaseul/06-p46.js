/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {

    let ans = [];
    
    function dfs(nums, part){
        if(nums.length === 0){
            return ans.push(part)
        }
        
        for(let i = 0; i < nums.length; i++){
            let numsCP = [...nums.slice(0, i), ...nums.slice(i+1)];
            dfs(numsCP, [...part, nums[i]])
        }
    }
    dfs(nums, [])
    return ans
    
};
