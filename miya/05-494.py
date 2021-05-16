from collections import defaultdict


class Solution:
    def findTargetSumWays(self, nums: list[int], target: int) -> int:
        count = defaultdict(int)
        count[0] = 1
        
        for x in nums:
            level = defaultdict(int)
            for y in count:
                level[y + x] += count[y]
                level[y - x] += count[y]
            count = level

        return count[target]