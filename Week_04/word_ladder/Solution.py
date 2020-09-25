from typing import List

# 单向 BFS
class Solution1:
    def ladderLength(self, beginWord, endWord, wordList):
        wordList = set(wordList)
        queue = collections.deque([[beginWord, 1]])
        while queue:
            word, length = queue.popleft()
            if word == endWord:
                return length
            for i in range(len(word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    next_word = word[:i] + c + word[i+1:]
                    if next_word in wordList:
                        wordList.remove(next_word)
                        queue.append([next_word, length + 1])
        return 0


# 双向 BFS
class Solution2:
    def ladderLength(self, begin_word: str, end_word: str, word_list: List[str]) -> int:
        word_set = set(word_list)
        if not word_set or end_word not in word_set:
            return 0

        begin_set, end_set, visited = set([begin_word]), set([end_word]), set([begin_word, end_word])

        step = 1
        while begin_set and end_set:
            if len(begin_set) > len(end_set):
                begin_set, end_set = end_set, begin_set

            next_to_visit = set()
            for word in begin_set:
                word_list = list(word)

                for i in range(len(word_list)):
                    old_char = word_list[i]

                    for char in 'abcdefghijklmnopqrstuvwxyz':
                        word_list[i] = char
                        new_word = ''.join(word_list)

                        if new_word in word_set:
                            if new_word in end_set:
                                return step + 1
                            if new_word not in visited:
                                next_to_visit.add(new_word)
                                visited.add(new_word)
                    word_list[i] = old_char
            step += 1
            begin_set = next_to_visit
        return 0


print(Solution().ladderLength('hit','cog',["hot","dot","dog","lot","log","cog"]))