package federico.benassi.algorithm.sort;

import static federico.benassi.ComparableUtils.*;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(Comparable<T>[] array) {
        for(int i = 0; i < array.length; i++) {
            Comparable min = array[i];
            int indexOfTheMin = i;
            for (int j = i; j < array.length; j++) {
                if(less(array[j], min)) {
                    min = array[j];
                    indexOfTheMin = j;
                }
            }
            exchange(array, i, indexOfTheMin);
        }
    }
}
