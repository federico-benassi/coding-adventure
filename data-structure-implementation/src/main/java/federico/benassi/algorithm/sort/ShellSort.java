package federico.benassi.algorithm.sort;

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
}
