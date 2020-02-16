package federico.benassi.algorithm.sort;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    private static final int CUTOFF = 7;

    public void sort(Comparable[] arr){
        sort(arr, new Comparable[arr.length], 0, arr.length - 1);
    }

    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo + CUTOFF - 1) {
            Sort.insertionSortForSubArrays(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        Sort.merge(a, aux, lo, mid, hi);
    }
}
