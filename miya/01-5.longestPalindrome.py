class Solution:
    def longestPalindrome(self, s: str) -> str:
        answer = s[0]
        for mid in range(len(s)):
            left, right = mid, mid
            while left>=0 and right<len(s) and s[left]==s[right]:
                if right-left+1>len(answer):
                    answer = s[left:right+1]
                left=left-1
                right=right+1

        for mid in range(len(s)-1):
            left, right = mid, mid+1
            while left>=0 and right<len(s) and s[left]==s[right]:
                if right-left+1>len(answer):
                    answer = s[left:right+1]
                left=left-1
                right=right+1
        return ''.join(answer)
