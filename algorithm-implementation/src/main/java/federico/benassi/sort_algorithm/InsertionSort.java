package federico.benassi.sort_algorithm;

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

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 88, 77, 46, 28, 59, 26, 59, 17, 58};
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(Comparable i : insertionSort(arr))
            sb.append(i).append(", ");

        sb.delete(sb.length() - 2, sb.length()).append("]");

        System.out.println(sb.toString());
    }
}
