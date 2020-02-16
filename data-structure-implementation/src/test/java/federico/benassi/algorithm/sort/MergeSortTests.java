package federico.benassi.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static federico.benassi.TestUtilities.SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY;
import static federico.benassi.TestUtilities.isSorted;
import static org.junit.Assert.assertTrue;

public class MergeSortTests {

    @Test
    public void bottomUpMergeSortShouldSortTheArray(){
        var copy = Arrays
                .copyOf(SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY, SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        Sort<Integer> bottomUpMergeSort = new SortFactory<Integer>()
                .getAlgorithm(SortAlgorithm.BOTTOM_UP_MERGE_SORT);
        bottomUpMergeSort.sort(copy);
        assertTrue(isSorted(copy));
    }

    @Test
    public void mergeSortShouldSortTheArray(){
        var copy = Arrays
                .copyOf(SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY, SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        Sort<Integer> mergeSort = new SortFactory<Integer>()
                .getAlgorithm(SortAlgorithm.MERGE_SORT);
        mergeSort.sort(copy);
        assertTrue(isSorted(copy));
    }
}
