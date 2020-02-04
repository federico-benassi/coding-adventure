package federico.benassi.tree;


import java.util.ArrayList;

public class BinaryHeap<T extends Comparable<T>> {

    ArrayList<T> internalArray;

    public BinaryHeap(){
        this.internalArray = new ArrayList<>();
    }

    // Child are at 2i + 1 and 2i + 2
    public void add(T value){
        internalArray.add(value);
        var actualIndex = internalArray.indexOf(value);
        do {
            if(internalArray.get(actualIndex).compareTo(internalArray.get((actualIndex - 1) / 2)) > 0){
                var temp = internalArray.get(actualIndex);
                internalArray.set(actualIndex, internalArray.get((actualIndex - 1) / 2));
                internalArray.set((actualIndex - 1) / 2, temp);
                continue;
            }
            break;
        } while(actualIndex != 0);
    }

    public T extract(){
        T minValue = this.internalArray.remove(this.internalArray.size() - 1);
        T toReturn = this.internalArray.get(0);
        this.internalArray.set(0, minValue);
        this.maxHeapify();
        return toReturn;
    }

    public void maxHeapify(){
        for(int i = 0; i < this.internalArray.size();){
            var parentValue = this.internalArray.get(i);
            T firstChild = null;
            T secondChild = null;
            if(i == 0) {
                if(i + 1 < internalArray.size()) firstChild = this.internalArray.get(i + 1);
                if(i + 2 < internalArray.size()) secondChild = this.internalArray.get(i + 2);
            } else {
                if(i * 2 + 1 < internalArray.size()) firstChild = this.internalArray.get(i * 2 + 1);
                if(i * 2 + 2 < internalArray.size()) secondChild = this.internalArray.get(i * 2 + 2);
            }

            if(firstChild == null) break;
            if(secondChild == null && parentValue.compareTo(firstChild) < 0) {
                var temp = this.internalArray.get(i);
                this.internalArray.set(i, this.internalArray.get(i * 2 + 1));
                this.internalArray.set(i * 2 + 1, temp);
                break;
            } else if(firstChild != null && secondChild != null && firstChild.compareTo(secondChild) > 0) {
                var temp = this.internalArray.get(i);
                this.internalArray.set(i, this.internalArray.get(i * 2 + 1));
                this.internalArray.set(i * 2 + 1, temp);
                if(i == 0) i = 1;
                else i = i * 2 + 1;
            } else if(firstChild != null && secondChild != null && secondChild.compareTo(firstChild) > 0){
                var temp = this.internalArray.get(i);
                this.internalArray.set(i, this.internalArray.get(i * 2 + 2));
                this.internalArray.set(i * 2 + 2, temp);
                if(i == 0) i = 2;
                else i = i * 2 + 2;
            }

        }
    }

    @Override
    public String toString() {
        return this.internalArray.toString();
    }
}
