package federico.benassi.data_structure.union_find;

public class WeightPathCompressionUnionFind {
    private int[] internalArray;
    private int[] sizes;

    public WeightPathCompressionUnionFind(int capacity){
        this.internalArray = new int[capacity];
        this.sizes = new int[capacity];

        for(int i = 0; i < this.internalArray.length; i++) {
            this.internalArray[i] = i;
            this.sizes[i] = 0;
        }
    }

    public void union(int p, int q){
        int pRoot = root(p);
        int qRoot = root(q);
        if(pRoot == qRoot) return;
        if(sizes[pRoot] < sizes[qRoot]) {
            this.internalArray[pRoot] = qRoot;
            this.sizes[qRoot] += this.sizes[pRoot];
        } else {
            this.internalArray[qRoot] = pRoot;
            this.sizes[pRoot] += qRoot;
        }
    }

    private int root(int i){
        int m = i;
        while(m != this.internalArray[m]) {
            m = this.internalArray[m];
        }
        int n = i;
        while(n != this.internalArray[n]){
            var previousIndex = n;
            n = this.internalArray[n];
            this.internalArray[previousIndex] = m;
        }

        return m;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
}
