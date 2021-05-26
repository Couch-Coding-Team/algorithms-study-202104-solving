from __future__ import annotations
from typing import List
from collections import deque


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        cols = len(board[0])
        moves = [[1,0], [0,1], [-1,0], [0, -1]]
        checked = board

        def helper(x, y, word):
            if len(word)==0:
                return True
            if x<0 or x>=rows or y<0 or y>=cols:
                return False
            if board[x][y]!=word[0]:
                return False
            checked[x][y]='0'
            for mx, my in moves:
                if helper(x+mx, y+my, word[1:]):
                    return True
            checked[x][y]=word[0]

        for i in range(rows):
            for j in range(cols):
                if helper(i, j, word):
                    return True
        return False

sol = Solution()

print(sol.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"))

print(sol.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "SEE"))

print(sol.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCB"))


