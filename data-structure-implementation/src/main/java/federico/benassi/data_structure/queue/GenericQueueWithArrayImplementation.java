package federico.benassi.data_structure.queue;

public class GenericQueueWithArrayImplementation<T> implements Queue<T> {

    private T[] internalArray;
    private int headPointer = 0;
    private int tailPointer = 0;

    public GenericQueueWithArrayImplementation(int capacity){
        this.internalArray = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T value) {
        internalArray[tailPointer++ % internalArray.length] = value;
    }

    @Override
    public T front() {
        return internalArray[headPointer % internalArray.length];
    }

    @Override
    public T dequeue() {
        var value = front();
        internalArray[headPointer++ % internalArray.length] = null;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return headPointer == tailPointer;
    }

    @Override
    public long getSize() {
        return tailPointer - headPointer;
    }
}
