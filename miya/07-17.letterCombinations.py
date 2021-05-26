       
import string
from itertools import product

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        ascii_lowercase =  list(string.ascii_lowercase)
        output = []
        phone = {
            '1' : [],
            '2' : ascii_lowercase[0:3],
            '3' : ascii_lowercase[3:6],
            '4' : ascii_lowercase[6:9],
            '5' : ascii_lowercase[9:12],
            '6' : ascii_lowercase[12:15],
            '7' : ascii_lowercase[15:19],
            '8' : ascii_lowercase[19:22],
            '9' : ascii_lowercase[22:26],
        }
        def helper(digits, position, word):
            if len(digits)==position:
                output.append(word)
                return
            cur = phone[digits[position]]
            for i in cur:
                helper(digits, position+1, word+i)
           
        helper(digits, 0, '')
        
        return output