package federico.benassi.sort_algorithm;

import static federico.benassi.ComparableUtils.*;

public class ShellSort {

    public static void shellSort(Comparable[] arr) {
        int sequence = 0;
        int x = 0;
        while (sequence < arr.length) sequence = 3 * x++ + 1;

        while ((sequence = 3 * --x + 1) > 0) {
            for (int i = sequence; i < arr.length; i++) {
                for (int j = i; j > 0; j -= sequence) {
                    if (less(arr[j], arr[j - 1])) {
                        exchange(arr, j, j - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 88, 77, 46, 28, 59, 26, 59, 17, 58};
        StringBuilder sb = new StringBuilder();
        shellSort(arr);
        sb.append("[");

        for(Integer i : arr)
            sb.append(i).append(", ");

        sb.delete(sb.length() - 2, sb.length()).append("]");

        System.out.println(sb.toString());
    }
}
