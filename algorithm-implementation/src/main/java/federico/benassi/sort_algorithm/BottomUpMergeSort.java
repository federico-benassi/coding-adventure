package federico.benassi.sort_algorithm;

import com.google.common.base.Stopwatch;

import static federico.benassi.ComparableUtils.less;


public class BottomUpMergeSort {

    public static void mergeSort(Comparable[] arr){

        Comparable[] aux = new Comparable[arr.length];
        for(int size = 1; size < arr.length; size += size){
            for(int i = 0; i < arr.length - size; i += size + size){
                merge(arr, aux, i, i + size - 1, Math.min(i + size + size - 1, arr.length - 1));
            }
        }

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
