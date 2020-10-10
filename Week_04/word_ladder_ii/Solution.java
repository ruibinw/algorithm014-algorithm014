package word_ladder_ii;

import java.util.*;

/**
 * BFS建图 + DFS回溯查找路径
 * Time: O(...)
 * Space: O(...)
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return result;
        }

        //BFS buildGraph
        Map<String, List<String>> graph = buildGraph(beginWord, endWord, wordSet);
        //DFS find all shortest path
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, graph, result, path);
        return result;
    }

    private void dfs(String curWord, String endWord, Map<String, List<String>> graph, List<List<String>> result, List<String> path) {
        if (curWord.equals(endWord)) {
            result.add(new ArrayList<>(path));
        }
        if (!graph.containsKey(curWord)) {
            return;
        }
        for (String nextWord : graph.get(curWord)) {
            path.add(nextWord);
            dfs(nextWord, endWord, graph, result, path);
            path.remove(path.size() - 1);
        }
    }

    private Map<String, List<String>> buildGraph(String beginWord, String endWord, Set<String> wordSet) {
        Map<String, List<String>> graph = new HashMap<>();

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        Set<String> visited = new HashSet<>();

        boolean found = false;
        boolean isBackward = false;

        while (!beginSet.isEmpty() && !found) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
                isBackward = !isBackward;
            }

            Set<String> nextLevelToVisit = new HashSet<>();
            for (String curWord : beginSet) {
                visited.add(curWord);
                for (String nextWord : getNextWords(curWord, wordSet)) {
                    if (visited.contains(nextWord) || beginSet.contains(nextWord)) {
                        continue;
                    }
                    if (endSet.contains(nextWord)) {
                        found = true;
                    }
                    nextLevelToVisit.add(nextWord);

                    //Graph = HashTable with parent and children relationship (Adjacency List)
                    String parent = isBackward ? nextWord : curWord;
                    String child = isBackward ? curWord : nextWord;
                    if (!graph.containsKey(parent)) {
                        graph.put(parent, new ArrayList<>());
                    }
                    graph.get(parent).add(child);
                }
            }
            beginSet = nextLevelToVisit;
        }
        return graph;
    }

    private List<String> getNextWords(String curWord, Set<String> wordSet) {
        List<String> nextWords = new ArrayList<>();
        char[] chars = curWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) {
                    continue;
                }
                chars[i] = c;
                String nextWord = new String(chars);
                if (wordSet.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
            chars[i] = old;
        }
        return nextWords;
    }
}
