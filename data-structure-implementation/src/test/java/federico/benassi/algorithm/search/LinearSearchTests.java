package federico.benassi.algorithm.search;

import org.junit.Test;

import java.util.Arrays;

import static federico.benassi.TestUtilities.MEDIUM_INTEGER_UNIQUE_ELEMENTS_ARRAY;
import static org.junit.Assert.*;
import static federico.benassi.TestUtilities.SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY;

public class LinearSearchTests {

    @Test
    public void linearSearchShouldFindTheElement(){
        var copy = Arrays
                .copyOf(SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY, SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        Search<Integer> linearSearch = new SearchFactory<Integer>()
                .getAlgorithm(SearchAlgorithm.LINEAR_SEARCH);
        assertEquals(3, linearSearch.search(copy, 3));
    }

    @Test
    public void linearSearchShouldFindTheElementOnMediumArray(){
        var copy = Arrays
                .copyOf(MEDIUM_INTEGER_UNIQUE_ELEMENTS_ARRAY, MEDIUM_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        Search<Integer> linearSearch = new SearchFactory<Integer>()
                .getAlgorithm(SearchAlgorithm.LINEAR_SEARCH);
        assertEquals(3765, linearSearch.search(copy, 3765));
    }
}
