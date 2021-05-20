class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        answer = []
        def helper(s=[], left=0, right=0):
            if len(s)==2*n:
                answer.append("".join(s))
                return 
            if left<n:
                s.append('(')
                helper(s, left+1, right)
                s.pop()
            if right<left:
                s.append(')')
                helper(s, left, right+1)
                s.pop()
        helper()
        return answer