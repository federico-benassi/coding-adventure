package federico.benassi.data_structure.priority_queue;

public interface PriorityQueue<T extends Comparable<T>> {

    void insert(T v);

    T delete();

    boolean isEmpty();
}
