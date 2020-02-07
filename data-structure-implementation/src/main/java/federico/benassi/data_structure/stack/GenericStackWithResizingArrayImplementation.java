package federico.benassi.data_structure.stack;

public class GenericStackWithResizingArrayImplementation<T> implements Stack<T> {

    private T[] internalArray;
    private int size = 0;

    public GenericStackWithResizingArrayImplementation() {
        internalArray = (T[]) new Object[1];
    }

    @Override
    public void push(T value) {
        if(size == internalArray.length) resize(2 * internalArray.length);
        internalArray[size++] = value;
    }

    @Override
    public T top() {
        return internalArray[size - 1];
    }

    @Override
    public T pop() {
        var value = top();
        internalArray[size - 1] = null;
        if(size > 0 && size == internalArray.length / 4) resize(internalArray.length / 2);
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

    private void resize(int capacity){
        T[] copy = (T[]) new Object[capacity];
        for(int i = 0; i < size; i++)
            copy[i] = internalArray[i];
        internalArray = copy;
    }
}