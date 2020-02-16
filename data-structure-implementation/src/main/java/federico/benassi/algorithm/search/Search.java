package federico.benassi.algorithm.search;

// Strategy Pattern
public interface Search<T extends Comparable<T>> {
    int search(Comparable<T>[] array, T element);
}
