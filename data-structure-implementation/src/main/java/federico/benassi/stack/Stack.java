package federico.benassi.stack;

import federico.benassi.linked_list.LinkedList;

public interface Stack<T> {

    void push(T value);

    T top();

    T pop();

    boolean isEmpty();

    long getSize();
}
