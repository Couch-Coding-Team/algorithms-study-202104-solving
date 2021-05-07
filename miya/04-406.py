class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people = sorted(people, key=lambda x: (-x[0], x[1]))
        print(people)
        answer = []
        for p in people:
            answer.insert(p[1], p)
            
        return answer