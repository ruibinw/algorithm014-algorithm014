package word_ladder;

import java.util.*;

/**
 * BFS，单向搜索
 * Time: O(n*26*m*m), n=wordList.size, m = wordLength (1st m = iterating to change every char in word, 2nd m = creating string from char array)
 * Space: O(n)
 */
class Solution1 {
    public static void main(String[] args) {
        new Solution1().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String curWord = queue.poll();
                if (changeLetterInWord(curWord, endWord, queue, visited, wordSet))
                    return step + 1;
            }
            step++;
        }
        return 0;
    }

    private boolean changeLetterInWord(String curWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] chars = curWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar)
                    continue;
                chars[i] = c;
                String nextWord = new String(chars);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord))
                        return true;
                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            chars[i] = originalChar;
        }
        return false;
    }
}

/**
 * BFS 双向搜索
 */
class Solution2 {
    public static void main(String[] args) {
        int i = new Solution2().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord))
            return 0;

        Set<String> toVisitFromBegin = new HashSet<>();
        toVisitFromBegin.add(beginWord);

        Set<String> toVisitFromEnd = new HashSet<>();
        toVisitFromEnd.add(endWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        int step = 1;
        while (!toVisitFromBegin.isEmpty() && !toVisitFromEnd.isEmpty()) {
            if (toVisitFromBegin.size() > toVisitFromEnd.size()) {
                Set<String> tmp = toVisitFromBegin;
                toVisitFromBegin = toVisitFromEnd;
                toVisitFromEnd = tmp;
            }

            Set<String> nextLevelToVisit = new HashSet<>();
            for (String curWord : toVisitFromBegin) {
                if (changeOneLetterInWord(curWord, toVisitFromEnd, visited, wordSet, nextLevelToVisit))
                    return step + 1;
            }
            step++;
            toVisitFromBegin = nextLevelToVisit;
        }
        return 0;
    }

    private boolean changeOneLetterInWord(String curWord, Set<String> toVisitFromEnd, Set<String> visited, Set<String> wordSet, Set<String> nextLevelToVisit) {
        char[] chars = curWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String nextWord = new String(chars);
                if (wordSet.contains(nextWord)) {
                    if (toVisitFromEnd.contains(nextWord))
                        return true;
                    if (!visited.contains(nextWord)) {
                        nextLevelToVisit.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            chars[i] = originalChar;
        }
        return false;
    }
}
