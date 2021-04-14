class Solution:
    def countSubstrings(self, s: str) -> int:
        s = list(s)
        n = len(s)
        check = [[False for _ in range(n)] for _ in range(n)]
        cnt =0
        for i in range(n):
            check[i][i] = True
            cnt+=1
        for i in range(1, n):
            if s[i-1] == s[i]:
                check[i-1][i] = True
                cnt+=1
        for l in range(3, n+1):
            for i in range(0, n-l+1):
                j = i+l-1
                if s[i] == s[j] and check[i+1][j-1]==True:
                    check[i][j] = True
                    cnt+=1
        return cnt