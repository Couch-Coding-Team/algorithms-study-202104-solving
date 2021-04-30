from collections import Counter

def solution(N, stages):
    answer = []
    count = Counter(stages)
    all_users = len(stages)
    clears = {}

    for i in range(1, N+1):
        if all_users<=0:
            clears[i] = 0
        else:
            clears[i] = count.get(i, 0)/all_users
            all_users-=count.get(i, 0)
    
    answer = sorted(clears, key=lambda x: clears[x], reverse=True)
    return answer


print(solution(5, [2,1,2,4,2,4,3,3]))