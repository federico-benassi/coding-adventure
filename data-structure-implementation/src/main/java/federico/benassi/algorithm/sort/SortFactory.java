package federico.benassi.algorithm.sort;

public class SortFactory <T extends Comparable<T>> {

    Sort<T> getAlgorithm(SortAlgorithm searchAlgorithm){
        switch (searchAlgorithm){
            case BOTTOM_UP_MERGE_SORT: return new BottomUpMergeSort<>();
            case BUBBLE_SORT: return new BubbleSort<>();
            case MERGE_SORT: return new MergeSort<>();
            case QUICK_SORT: return new QuickSort<>();
            case SELECTION_SORT: return new SelectionSort<>();
            case SHELL_SORT: return new ShellSort<>();
            case SHUFFLE: return new Shuffle<>();
            case HEAP_SORT: return new HeapSort<>();
            case INSERTION_SORT:
            default: return new InsertionSort();
        }
    }
}
