# 使用计数器 count
# 遇到左括号 count+1，当 count == 1，不添加（去掉最左边的左括号）
# 遇到右括号 count-1，当 count == 0, 不添加（去掉最右边的右括号）
class Solution:
    def removeOuterParentheses(self, S: str) -> str:
        result = []
        count = 0
        for s in S:
            if s == '(':
                count += 1
                if count > 1: result.append(s)
            if s == ')':
                count -= 1
                if count > 0: result.append(s)
        return ''.join(result)
