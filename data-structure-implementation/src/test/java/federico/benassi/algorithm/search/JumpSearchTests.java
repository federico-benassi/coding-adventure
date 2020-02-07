package federico.benassi.algorithm.search;

import org.junit.Test;

import java.util.Arrays;

import static federico.benassi.algorithm.sort.InsertionSort.insertionSort;
import static org.junit.Assert.*;
import static federico.benassi.TestUtilities.SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY;

public class JumpSearchTests {

    @Test
    public void jumpSearchShouldFindTheElement(){
        var copy = Arrays
                .copyOf(SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY, SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        insertionSort(copy);
        assertEquals(2, JumpSearch.jumpSearch(copy, 3));
    }

}
