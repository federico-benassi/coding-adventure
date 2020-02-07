package federico.benassi.data_structure.stack;

public class GenericStackWithArrayImplementation<T> implements Stack<T> {

    private T[] internalArray;
    private int size = 0;

    public GenericStackWithArrayImplementation(int capacity){
        this.internalArray = (T[]) new Object[capacity];
    }

    @Override
    public void push(T value) {
        internalArray[size++] = value;
    }

    @Override
    public T top() {
        return internalArray[size - 1];
    }

    @Override
    public T pop() {
        var value = top();
        internalArray[size--] = null;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public long getSize() {
        return size;
    }
}
