package federico.benassi.sort_algorithm;

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

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{2, 88, 77, 46, 28, 59, 26, 59, 17, 58};
        StringBuilder sb = new StringBuilder();
        selectionSort(arr);
        sb.append("[");

        for(Integer i : arr)
            sb.append(i).append(", ");

        sb.delete(sb.length() - 2, sb.length()).append("]");

        System.out.println(sb.toString());
    }
}
