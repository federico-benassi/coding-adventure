package federico.benassi.data_structure.union_find;

public class QuickUnionFind {
    private int[] internalArray;

    public QuickUnionFind(int capacity){
        this.internalArray = new int[capacity];

        for(int i = 0; i < this.internalArray.length; i++)
            this.internalArray[i] = i;
    }

    public void union(int p, int q){
        int pRoot = root(p);
        int qRoot = root(q);

        this.internalArray[pRoot] = qRoot;
    }

    private int root(int i){
        while(i != this.internalArray[i]) i = this.internalArray[i];
        return i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
}
