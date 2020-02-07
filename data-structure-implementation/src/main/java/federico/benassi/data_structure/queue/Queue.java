package federico.benassi.data_structure.queue;

public interface Queue<T> {
    void enqueue(T value);

    T front();

    T dequeue();

    boolean isEmpty();

    long getSize();
}
