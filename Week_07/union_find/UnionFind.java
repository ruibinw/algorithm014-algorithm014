package union_find;

public class UnionFind {
    //记录父节点，如果一个节点的父节点是该节点本身，说明该节点是根节点
    private int[] parent;
    //记录每个数的重量，用于进行平衡树优化
    private int[] weight;
    //记录连通分量个数
    int count;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1;//最初每棵树只有一个节点，重量初始化为 1
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        //进行平衡树优化，将小树的根节点指向大树的根节点
        if (weight[rootP] > weight[rootQ]) {
            parent[rootQ] = rootP;
            weight[rootP] += weight[rootQ];
        } else {
            parent[rootP] = rootQ;
            weight[rootQ] += weight[rootP];
        }
        count--;
    }

    //判断两个结点是否连通 = 判断两个结点的根节点是否相等
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //查找 x 的根节点
    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];//每次查找时，都顺手进行路径压缩
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }
}
