package federico.benassi.algorithm.sort;

import static federico.benassi.ComparableUtils.*;
import static federico.benassi.algorithm.sort.InsertionSort.insertionSortForSubArrays;

public class MergeSort {

    private static final int CUTOFF = 7;

    public static void bottomUpMergeSort(Comparable[] arr){

        Comparable[] aux = new Comparable[arr.length];
        for(int size = 1; size < arr.length; size += size){
            for(int i = 0; i < arr.length - size; i += size + size){
                merge(arr, aux, i, i + size - 1, Math.min(i + size + size - 1, arr.length - 1));
            }
        }

    }

    public static void mergeSort(Comparable[] arr){
        sort(arr, new Comparable[arr.length], 0, arr.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo + CUTOFF - 1) {
            insertionSortForSubArrays(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux,  int lo, int mid, int hi){

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++){
            if      (i > mid)           a[k] = aux[j++];
            else if (j > hi)            a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }
}
