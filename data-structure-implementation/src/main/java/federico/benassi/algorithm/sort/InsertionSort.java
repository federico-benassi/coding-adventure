package federico.benassi.algorithm.sort;

import static federico.benassi.ComparableUtils.*;

public class InsertionSort {

    public static Comparable[] insertionSort(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(less(arr[j], arr[j - 1])){
                    exchange(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }

        return arr;
    }

    public static void insertionSortForSubArrays(Comparable[] arr, int lo, int hi){
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
}
