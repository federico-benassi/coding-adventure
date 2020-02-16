package federico.benassi.algorithm.search;

import federico.benassi.algorithm.sort.InsertionSort;
import federico.benassi.algorithm.sort.Sort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static federico.benassi.TestUtilities.SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY;

public class JumpSearchTests {

    @Test
    public void jumpSearchShouldFindTheElement(){
        var copy = Arrays
                .copyOf(SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY, SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length);
        Sort<Integer> insertionSort = new InsertionSort<>();
        insertionSort.sort(copy);
        Search<Integer> jumpSearch = new SearchFactory<Integer>()
                .getAlgorithm(SearchAlgorithm.JUMP_SEARCH);
        assertEquals(3, jumpSearch.search(copy, 3));
    }

}
