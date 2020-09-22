class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        i, j = 0, 0
        while i < len(g) and j < len(s):
            if g[i] <= s[j]: #饼干小于等于孩子的胃口时 = 可以满足当前孩子
                i += 1 #轮到下一个孩子
            j += 1 #继续拿出下一个饼干，无论满不满足当前孩子
        return i
