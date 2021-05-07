from collections import defaultdict

class Solution:
    def partitionLabels(self, S: str) -> [int]:
        word_map = defaultdict(list)
        answer2 = []
        for i in range(len(S)):
            word_map[S[i]].append(i)
        s, e = None, None

        for k, v in word_map.items():
            if s == None and e==None:
                s, e = v[0], v[-1]
            else:
                start, end = v[0], v[-1]
                if s< start and e < start:
                    answer2.append(e-s+1)
                    s, e = start, end
                elif s < start < e and e<end:
                    e = end
         
        answer2.append(e-s+1)
        return answer2

