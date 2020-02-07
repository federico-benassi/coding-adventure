package federico.benassi.algorithm.sort;

import static federico.benassi.ComparableUtils.exchange;
import static federico.benassi.ComparableUtils.less;
import static federico.benassi.algorithm.sort.InsertionSort.insertionSortForSubArrays;

public class QuickSort {

    private static final int CUTOFF = 10;

    public static void quickSort(Comparable[] arr){
        Shuffle.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Comparable[] arr, int lo, int hi){
        if(hi <= lo + CUTOFF - 1) {
            insertionSortForSubArrays(arr, lo, hi);
            return;
        }
        var indexOfPartiotion = partition(arr, lo, hi);
        sort(arr, lo, indexOfPartiotion - 1);
        sort(arr, indexOfPartiotion + 1, hi);
    }

    public static int partition(Comparable[] arr, int lo, int hi){
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
