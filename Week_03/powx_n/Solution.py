# 递归
# 时间复杂度：O(logn)
# 空间复杂度：O(logn)
class Solution1:
    def myPow(self, x: float, n: int) -> float:
        # 传正数 n
        def pow(n):
            if n == 0: return 1
            y = pow(n >> 1)
            return y * y if n & 1 == 0 else y * y * x

        # 处理 n 如果是负数
        return pow(n) if n >= 0 else 1 / pow(-n)


# 循环
# 时间复杂度：O(logn)
# 空间复杂度：O(1)
class Solution2:
    def myPow(self, x: float, n: int) -> float:
        if x == 0.0: return 0.0
        res = 1
        if n < 0: x, n = 1 / x, -n
        while n:
            if n & 1: res *= x
            x *= x
            n >>= 1
        return res
