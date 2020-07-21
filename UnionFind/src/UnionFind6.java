//我们的第六版Union-Find
public class UnionFind6 implements UF {
    private int[] parent; //parent[i]表示第i个元素所指向的父节点
    private int[] rank; //rank[i]表示以i为根的集合所表示的树的层数

    public UnionFind6 (int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查找过程，查找元素p所对应的集合编号
    //O(h)复杂度，h为树的高度
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }

        return parent[p];
    }

    //查看元素p和元素q是否属于一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        //根据两个元素所在树的rank不同判断合并方向
        //将rank低的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
