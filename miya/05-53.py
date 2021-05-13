
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        
        def helper(nums):
            max_sum = nums[0]
            for i in range(1, len(nums)):
                if nums[i-1] > 0:
                    nums[i] += nums[i-1]
                max_sum = max(max_sum, nums[i])
            return max_sum
        
        return helper(nums)
