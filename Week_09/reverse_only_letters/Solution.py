# Two pointer, reverse char array but skip char that is not a letter
class Solution1:
    def reverseOnlyLetters(self, S: str) -> str:
        s = list(S) # python str is immutable, convert to list first
        i, j = 0, len(s) - 1
        while i < j:
            while i < j and not s[i].isalpha(): i += 1
            while i < j and not s[j].isalpha(): j -= 1
            if i < j:
                s[i], s[j] = s[j], s[i]
                i, j = i + 1, j - 1
        return "".join(s)


# Stack
class Solution2:
    def reverseOnlyLetters(self, S: str) -> str:
        letters = [c for c in S if c.isalpha()]

        ans = []
        for c in S:
            if c.isalpha():
                ans.append(letters.pop())
            else:
                ans.append(c)

        return "".join(ans)