package federico.benassi.sort_algorithm;

import com.google.common.base.Stopwatch;

import static federico.benassi.ComparableUtils.*;

public class MergeSort {

    private static final int CUTOFF = 7;

    public static void mergeSort(Comparable[] arr){
        sort(arr, new Comparable[arr.length], 0, arr.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo + CUTOFF - 1) {
            insertionSort(a, lo, hi);
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

    private static void insertionSort(Comparable[] arr, int lo, int hi){
        for(int i = lo; i < hi; i++){
            for(int j = i; j > lo; j--){
                if(less(arr[j], arr[j - 1])){
                    exchange(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[100000];
        for(int i = arr.length; i > 0; i--){
            arr[i - 1] = i;
        }
        StringBuilder sb = new StringBuilder();
        Stopwatch stopwatch = Stopwatch.createStarted();
        mergeSort(arr);
        System.out.println(stopwatch.elapsed());
        sb.append("[");

        for(Integer i : arr)
            sb.append(i).append(", ");

        sb.delete(sb.length() - 2, sb.length()).append("]");

        System.out.println(sb.toString());
    }
}
