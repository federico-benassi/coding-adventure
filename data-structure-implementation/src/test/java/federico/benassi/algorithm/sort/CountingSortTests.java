package federico.benassi.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static federico.benassi.TestUtilities.*;
import static federico.benassi.algorithm.sort.CountingSort.countingSort;
import static org.junit.Assert.assertTrue;

public class CountingSortTests {

    @Test
    public void countingSortShouldSortTheArray(){
        var copy = Arrays
                .copyOf(SMALL_INT_UNIQUE_ELEMENTS_ARRAY, SMALL_INT_UNIQUE_ELEMENTS_ARRAY.length);
        countingSort(copy);
        assertTrue(isSorted(copy));
    }
}
