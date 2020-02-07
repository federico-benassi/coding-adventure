package federico.benassi.priority_queue;

// Binary Tree --> Complete Binary Tree --> Binary Heap
// Heap-ordered binary tree: keys in nodes and parent's key not smaller than children's keys
public class MaxPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private T[] internalArray;
    private int index = 0;
    private final int DEFAULT_CAPACITY = 2;


    public MaxPriorityQueue(){
        this.internalArray = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    private void grow(int capacity){
        var copy = (T[]) new Comparable[capacity];
        for(int i = 0; i < internalArray.length; i++)
            copy[i] = internalArray[i];
        internalArray = copy;
    }

    @Override
    public void insert(T v) {
        if(internalArray.length == index + 1) grow(internalArray.length * 2);
        internalArray[++index] = v;
        swim(index);
    }

    @Override
    public T delete() {
        T max = internalArray[1];
        exchange(1, index--);
        sink(1);
        internalArray[index + 1] = null;
        return max;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }


    private void swim(int index){
        while(index > 1 && less(index / 2, index)){
            exchange(index / 2, index);
            index = index / 2;
        }
    }

    private void sink(int parentIndex){
        while(2*parentIndex <= index){
            int j = 2*parentIndex;
            if(j < index && less(j, j + 1)) j++;
            if(!less(parentIndex, j)) break;
            exchange(parentIndex, j);
            parentIndex = j;
        }
    }

    private boolean less(int index, int index2){
        return internalArray[index].compareTo(internalArray[index2]) < 0;
    }

    private void exchange(int index, int index2){
        var temp = internalArray[index];
        internalArray[index] = internalArray[index2];
        internalArray[index2] = temp;
    }
}
