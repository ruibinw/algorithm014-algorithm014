class Solution1:
    def addDigits(self, num: int) -> int:
        while num >= 10:
            num = int(num / 10) + num % 10
        return num


class Solution2:
    def addDigits(self, num: int) -> int:
        if num < 10: return num
        return self.addDigits(int(num / 10) + num % 10)


class Solution3:
    def addDigits(self, num: int) -> int:
        return 0 if num == 0 else (num - 1) % 9 + 1