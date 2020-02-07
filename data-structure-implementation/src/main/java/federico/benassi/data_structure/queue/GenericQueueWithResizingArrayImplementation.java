package federico.benassi.data_structure.queue;

public class GenericQueueWithResizingArrayImplementation<T> implements Queue<T> {

    private T[] internalArray = (T[]) new Object[1];
    private int headPointer = 0;
    private int tailPointer = 0;

    @Override
    public void enqueue(T value) {
        if(getSize() == internalArray.length) resize(internalArray.length * 2);
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
        if(getSize() == internalArray.length / 4) shrink(internalArray.length / 2);
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

    private void resize(int capacity){
        T[] copy = (T[]) new Object[capacity];
        for(int i = 0; i < internalArray.length; i++)
            copy[i] = internalArray[i];
        internalArray = copy;
    }

    private void shrink(int capacity){
        T[] copy = (T[]) new Object[capacity];
        for(int i = headPointer; i <= tailPointer; i++){
            copy[i - headPointer] = internalArray[i];
        }
        internalArray = copy;
        tailPointer -= headPointer;
        headPointer = 0;
    }
}
