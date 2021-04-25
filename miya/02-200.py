from collections import deque

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        q = deque()
        m, n = len(grid), len(grid[0])
        
        check = [[-1 for _ in range(n)] for _ in range(m)]
        move = [(1,0),(-1,0),(0,1),(0,-1)]
        cnt = 0
        def bfs(x,y,cnt):
            q.append((x,y))
            check[x][y]=cnt
            while q:
                x, y = q.popleft()
                for dx, dy in move:
                    sx, sy = x+dx, y+dy
                    if 0<=sx<m and 0<=sy<n and \
                    grid[sx][sy]=="1" and check[sx][sy]==-1:
                        check[sx][sy] = cnt
                        q.append((sx,sy))
            
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1" and check[i][j]==-1:
                    cnt+=1
                    bfs(i, j, cnt)
                    
        return cnt