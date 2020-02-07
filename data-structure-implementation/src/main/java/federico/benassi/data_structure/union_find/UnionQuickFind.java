package federico.benassi.data_structure.union_find;

public class UnionQuickFind {
    private int[] internalArray;

    public UnionQuickFind(int capacity){
        this.internalArray = new int[capacity];

        for(int i = 0; i < this.internalArray.length; i++)
            this.internalArray[i] = i;
    }

    // Quadratic times for union n times for n objects
    public void union(int p, int q){
        var id = this.internalArray[p];
        var toBeFound = this.internalArray[q];
        for(int i = 0; i < this.internalArray.length; i++){
            if(this.internalArray[i] == toBeFound){
                this.internalArray[i] = id;
            }
        }
    }

    public boolean connected(int p, int q){
        return this.internalArray[p] == this.internalArray[q];
    }
}
