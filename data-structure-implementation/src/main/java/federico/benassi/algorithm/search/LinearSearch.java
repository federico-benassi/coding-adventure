package federico.benassi.algorithm.search;

public class LinearSearch {

    // Worst case is O(n) where n is the length of the array
    public static int linearSearch(Comparable[] arr, Comparable elementToBeFound){
        for(int i = 0; i < arr.length; i++)
            if(arr[i].compareTo(elementToBeFound) == 0) return i;

        return -1;
    }
}
