package federico.benassi.algorithm.sort;

import static federico.benassi.ComparableUtils.exchange;
import static federico.benassi.ComparableUtils.less;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    private static final int CUTOFF = 10;


    @Override
    public void sort(Comparable<T>[] array) {
        Sort<T> shuffle = new Shuffle<>();
        shuffle.sort(array);
        sort(array, 0, array.length - 1);
    }

    private void sort(Comparable[] arr, int lo, int hi){
        if(hi <= lo + CUTOFF - 1) {
            Sort.insertionSortForSubArrays(arr, lo, hi);
            return;
        }
        var indexOfPartiotion = partition(arr, lo, hi);
        sort(arr, lo, indexOfPartiotion - 1);
        sort(arr, indexOfPartiotion + 1, hi);
    }

    private int partition(Comparable[] arr, int lo, int hi){
        int i = lo, j = hi + 1;
        while(true){
            while(less(arr[++i], arr[lo])){
                if(i == hi) break;
            }
            while(less(arr[lo], arr[--j])){
                if(j == lo) break;
            }
            if( i >= j ) break;
            exchange(arr, i, j);
        }

        exchange(arr, lo, j);
        return j;
    }
}
