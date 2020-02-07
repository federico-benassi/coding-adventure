package federico.benassi.algorithm.search;

public class JumpSearch {

    // Work only on sorted arrays and worst case O(n/m)
    public static int jumpSearch(Comparable[] arr, Comparable elementToBeFound){
        int m = (int) Math.sqrt(arr.length);

        for(int i = 0; i < arr.length; i += m){
            if(arr[i].compareTo(elementToBeFound) > 0){
                for(int j = i - m; j < i; j++){
                    if(arr[j] == elementToBeFound) return j;
                }
                return -1;
            }
        }

        return -1;
    }
}
