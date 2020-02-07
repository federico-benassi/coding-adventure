package federico.benassi.algorithm.search;

public class BinarySearch {

    // Work only on sorted arrays and worst case is O(log(n))
    public static int binarySearch(Comparable[] arr, Comparable elementToBeFound){
        int l = 0;
        int r = arr.length - 1;

        while(true){
            if(l > r) return -1;
            int m = (l + r) / 2;
            if(arr[m].compareTo(elementToBeFound) == 0) return m;
            if(arr[m].compareTo(elementToBeFound) < 0) l = m + 1;
            if(arr[m].compareTo(elementToBeFound) > 0) r = m - 1;
        }
    }
}
