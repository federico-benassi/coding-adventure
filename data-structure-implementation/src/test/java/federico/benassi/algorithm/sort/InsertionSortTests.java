package federico.benassi.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static federico.benassi.TestUtilities.SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY;
import static federico.benassi.TestUtilities.isSorted;
import static org.junit.Assert.assertTrue;

public class InsertionSortTests {

    @Test
    public void insertionSortShouldSortTheArray(){
        var copy = Arrays
                .copyOf(SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY, SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        Sort<Integer> insertionSort = new SortFactory<Integer>()
                .getAlgorithm(SortAlgorithm.INSERTION_SORT);
        insertionSort.sort(copy);
        assertTrue(isSorted(copy));
    }
}
