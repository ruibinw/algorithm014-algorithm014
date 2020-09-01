from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def generate(s = "", l = 0, r = 0):
            if l == n and r == n:
                res.append(s)
                return
            if l < n: generate(s + "(", l + 1, r)
            if r < l: generate(s + ")", l, r + 1)
        generate()
        return res

