package federico.benassi.algorithm.sort;

import static federico.benassi.ComparableUtils.exchange;
import static federico.benassi.ComparableUtils.less;

// Strategy Pattern
public interface Sort<T extends Comparable<T>> {

    void sort(Comparable<T>[] array);

    static void insertionSortForSubArrays(Comparable[] arr, int lo, int hi){
        for(int i = lo; i <= hi; i++){
            for(int j = i; j > lo; j--){
                if(less(arr[j], arr[j - 1])){
                    exchange(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    static void merge(Comparable[] a, Comparable[] aux,  int lo, int mid, int hi){

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
