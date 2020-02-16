package federico.benassi.algorithm.search;

public class SearchFactory<T extends Comparable<T>> {

    Search<T> getAlgorithm(SearchAlgorithm algorithm){
        switch (algorithm){
            case JUMP_SEARCH: return new JumpSearch<>();
            case BINARY_SEARCH: return new BinarySearch<>();
            case LINEAR_SEARCH:
            default: return new LinearSearch<>();
        }
    }
}
