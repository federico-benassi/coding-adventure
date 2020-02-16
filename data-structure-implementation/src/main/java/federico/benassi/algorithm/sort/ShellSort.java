package federico.benassi.algorithm.sort;

import static federico.benassi.ComparableUtils.*;

public class ShellSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(Comparable<T>[] array) {
        int sequence = 0;
        int x = 0;
        while (sequence < array.length) sequence = 3 * x++ + 1;

        while ((sequence = 3 * --x + 1) > 0) {
            for (int i = sequence; i < array.length; i++) {
                for (int j = i; j > 0; j -= sequence) {
                    if (less(array[j], array[j - 1])) {
                        exchange(array, j, j - 1);
                    }
                }
            }
        }
    }
}
