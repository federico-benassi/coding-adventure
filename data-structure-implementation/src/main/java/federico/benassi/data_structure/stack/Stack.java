package federico.benassi.data_structure.stack;

public interface Stack<T> {

    void push(T value);

    T top();

    T pop();

    boolean isEmpty();

    long getSize();
}
