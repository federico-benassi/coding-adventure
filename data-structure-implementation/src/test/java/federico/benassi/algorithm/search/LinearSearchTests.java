package federico.benassi.algorithm.search;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static federico.benassi.TestUtilities.SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY;

public class LinearSearchTests {

    @Test
    public void linearSearchShouldFindTheElement(){
        var copy = Arrays
                .copyOf(SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY, SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        assertEquals(3, LinearSearch.linearSearch(copy, 3));
    }
}
