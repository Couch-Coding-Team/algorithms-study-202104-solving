from copy import copy
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def permutation(items, r=0):
            result = []
            prev = []

            def dfs(elements):
                if (len(elements)-r) == 0:
                    result.append(copy(prev))

                for idx, e in enumerate(elements):
                    prev.append(e)
                    dfs(elements[:idx]+elements[idx+1:])
                    prev.pop()

            dfs(items)

            return result
        return permutation(nums)