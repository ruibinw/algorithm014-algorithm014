# 排序后 逐个字符进行比较
# time: O(nlogn) 排序的时间复杂度
# space: O(n)
class Solution1:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        return sorted(s) == sorted(t)

# count character
# time: O(n)
# space: O(1)
class Solution1:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        char_count = [0] * 26
        for i in range(len(s)):
            char_count[ord(s[i]) - ord('a')] += 1
            char_count[ord(t[i]) - ord('a')] -= 1

        for count in char_count:
            if count != 0:
                return False

        return True

        # return all([s.count(c) == t.count(c) for c in string.ascii_lowercase])