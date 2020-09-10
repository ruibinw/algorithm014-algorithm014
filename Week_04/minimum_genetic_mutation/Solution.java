package minimum_genetic_mutation;

import java.util.*;

/**
 * 单向 BFS
 */
class Solution1 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (bankSet.size() == 0 || !bankSet.contains(end))
            return -1;

        Queue<String> queue = new ArrayDeque<>(){{add(start);}};
        Set<String> visited = new HashSet<>(){{add(start);}};

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                String gene = queue.poll();
                if (mutate(gene, end, bankSet, visited, queue)) {
                    return count;
                }
            }
        }
        return -1;
    }

    private boolean mutate(String gene, String endGene, Set<String> bankSet, Set<String> visited, Queue<String> queue) {
        char[] geneChar = {'A', 'C', 'G', 'T'};
        char[] cs = gene.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char originalChar = cs[i];
            for (char g : geneChar) {
                cs[i] = g;
                String nextGene = new String(cs);
                if (bankSet.contains(nextGene)) {
                    if (nextGene.equals(endGene))
                        return true;
                    if (!visited.contains(nextGene)) {
                        queue.add(nextGene);
                        visited.add(nextGene);
                    }
                }
            }
            cs[i] = originalChar;
        }
        return false;
    }
}

/**
 * 双向 BFS
 */
class Solution2 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (bankSet.size() == 0 || !bankSet.contains(end))
            return -1;

        char[] acgt = {'A', 'C', 'G', 'T'};

        Set<String> startSet = new HashSet<>(){{ add(start); }};
        Set<String> endSet = new HashSet<>(){{ add(end); }};
        Set<String> visited = new HashSet<>(){{ add(start); add(end); }};

        int count = 0;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            count++;
            if (startSet.size() > endSet.size()) {
                Set<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }
            Set<String> nextLevelTovisit = new HashSet<>();
            for (String gene : startSet) {
                char[] cs = gene.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    char originalChar = cs[i];
                    for (char c : acgt) {
                        cs[i] = c;
                        String nextGene = new String(cs);
                        if (bankSet.contains(nextGene)) {
                            if (endSet.contains(nextGene))
                                return count;
                            if (!visited.contains(nextGene)) {
                                nextLevelTovisit.add(nextGene);
                                visited.add(nextGene);
                            }
                        }
                    }
                    cs[i] = originalChar;
                }
            }
            startSet = nextLevelTovisit;
        }
        return -1;
    }
}
