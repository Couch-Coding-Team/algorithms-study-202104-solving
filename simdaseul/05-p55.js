var maxSubArray = function(nums) {
    var result = nums[0];
    var sum = 0;
    for(var i = 0; i < nums.length; i++) {
        sum += nums[i];
        if(result < sum) result = sum;
        if(sum < 0) sum = 0;
    }
    return result;
};
