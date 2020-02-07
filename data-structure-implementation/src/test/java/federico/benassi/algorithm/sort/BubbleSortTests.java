package federico.benassi.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static federico.benassi.TestUtilities.SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY;
import static federico.benassi.TestUtilities.isSorted;
import static federico.benassi.algorithm.sort.BubbleSort.bubbleSort;
import static org.junit.Assert.assertTrue;

public class BubbleSortTests {

    @Test
    public void bubbleSortShouldSortTheArray(){
        var copy = Arrays
                .copyOf(SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY, SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        bubbleSort(copy);
        assertTrue(isSorted(copy));
    }
}
