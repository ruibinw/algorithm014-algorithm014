class Solution:
    def numDecodings(self, s: str) -> int:
        if len(s) == 0 or s[0] == '0':
            return 0

        one, two = 1, 1
        for i in range(len(s)):
            sum = 0
            if s[i] > '0':
                sum += one
            if i > 0 and '10' <= s[i - 1:i + 1] <= '26':
                sum += two
            two = one
            one = sum
        return sum
