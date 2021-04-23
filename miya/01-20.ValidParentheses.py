class Solution:
    def isValid(self, s: str) -> bool:
        s = list(s)
        bracket = {
            ')':'(',
            ']':'[',
            '}':'{'
        }
        stack = []
        for i in range(len(s)):
            if len(stack)==0:
                stack.append(s[i])
            else:
                if s[i] in ')]}':
                    if bracket[s[i]] == stack[-1]:
                        stack.pop()
                    else:
                        return False
                else:
                    stack.append(s[i])
        if len(stack) == 0:
            return True
        else:
            return False