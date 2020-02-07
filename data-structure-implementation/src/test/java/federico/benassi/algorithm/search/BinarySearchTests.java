package federico.benassi.algorithm.search;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static federico.benassi.algorithm.sort.InsertionSort.insertionSort;
import static federico.benassi.TestUtilities.SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY;

public class BinarySearchTests {

    @Test
    public void binarySearchShouldFindTheElement(){
        var copy = Arrays
                .copyOf(SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY, SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        insertionSort(copy);
        assertEquals(2, BinarySearch.binarySearch(copy, 3));
    }
}
