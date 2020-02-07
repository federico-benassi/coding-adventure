package federico.benassi.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static federico.benassi.TestUtilities.SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY;
import static federico.benassi.TestUtilities.isSorted;
import static federico.benassi.algorithm.sort.MergeSort.bottomUpMergeSort;
import static federico.benassi.algorithm.sort.MergeSort.mergeSort;
import static org.junit.Assert.assertTrue;

public class MergeSortTests {

    @Test
    public void bottomUpMergeSortShouldSortTheArray(){
        var copy = Arrays
                .copyOf(SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY, SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        bottomUpMergeSort(copy);
        assertTrue(isSorted(copy));
    }

    @Test
    public void mergeSortShouldSortTheArray(){
        var copy = Arrays
                .copyOf(SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY, SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        mergeSort(copy);
        assertTrue(isSorted(copy));
    }
}
