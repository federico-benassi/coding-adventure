package federico.benassi.algorithm.sort;

import static federico.benassi.ComparableUtils.*;

public class SelectionSort {

    public static void selectionSort(Comparable[] arr){
        for(int i = 0; i < arr.length; i++) {
            Comparable min = arr[i];
            int indexOfTheMin = i;
            for (int j = i; j < arr.length; j++) {
                if(less(arr[j], min)) {
                    min = arr[j];
                    indexOfTheMin = j;
                }
            }
            exchange(arr, i, indexOfTheMin);
        }
    }
}
