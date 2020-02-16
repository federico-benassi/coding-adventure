package federico.benassi.algorithm.search;

public class LinearSearch<T extends Comparable<T>> implements Search<T> {

    // Worst case is O(n) where n is the length of the array
    public int search(Comparable<T>[] arr, T elementToBeFound){
        for(int i = 0; i < arr.length; i++)
            if(arr[i].compareTo(elementToBeFound) == 0) return i;

        return -1;
    }
}
