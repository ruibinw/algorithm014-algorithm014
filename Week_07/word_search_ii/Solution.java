package word_search_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力法：回溯
 * 时间复杂度: O(N * n*m * 4^k)
 * 遍历所有单词，N 个单词
 * 每个单词都要尝试从board的每个元素开始搜索 n*m 个元素
 * 单词长度平均为 k，查找单词的所有字母，需要进行 dfs 4个方向 = 4^k
 */
class Solution1 {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int rows;
    int cols;

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) ans.add(word);
        }
        return ans;
    }

    private boolean exist(char[][] board, String word) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (exist(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int ci, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(ci))
            return false;

        if (ci == word.length() - 1)
            return true;

        char original = board[i][j];
        board[i][j] = '*';//标记当前元素为访问过
        for (int k = 0; k < 4; k++) {
            if(exist(board, word, ci + 1, i + directions[k][0], j + directions[k][1])) {
                board[i][j] = original;//进行回溯：尝试上下左右搜索后，还原当前元素
                return true;
            }
        }
        board[i][j] = original;//进行回溯：尝试上下左右搜索后，还原当前元素
        return false;
    }
}

/**
 * 回溯 + Trie
 * 从board的每个元素开始 dfs, 总共 m*n 个起点（有的起点不包含在所有单词的首字母，会跳过，所以 m*n 是最坏情况）
 * 每一轮 dfs 要进行 4 个方向的搜索，递归分成 4 个分支，最坏情况下深入递归 k 层（最大的单词长度） = 4^k 次调用 dfs函数
 * 最终时间复杂度为 O(n * m * 4^k)
 */
class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "eat"}));
    }

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int rows;
    int cols;

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;
        List<String > result = new ArrayList<>();
        TrieNode trie = TrieNode.build(words);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, trie, i, j, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, TrieNode t, int i, int j, List<String> result) {
        char c = board[i][j];
        if (c == '*' || t.next[c - 'a'] == null) return;
        t = t.next[c - 'a'];
        if (t.word != null) {   //找到一个单词
            result.add(t.word);
            t.word = null;      //防止其他单词的前缀和当前单词相同的情况，导致重复结果
        }

        board[i][j] = '*';
        for (int[] dir : directions) {
            int di = i + dir[0], dj = j + dir[1];
            if (di < 0 || di >= rows || dj < 0 || dj >= cols) continue;
            dfs(board, t, di, dj, result);
        }
        board[i][j] = c;
    }
}

class TrieNode {
    String word;
    TrieNode[] next = new TrieNode[26];

    static TrieNode build(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                int ci = word.charAt(i) - 'a';
                if (node.next[ci] == null)
                    node.next[ci] = new TrieNode();
                node = node.next[ci];
            }
            node.word = word; //将单词存放在该单词路径的最后节点
        }
        return root;
    }
}
