package federico.benassi.linear_search;

public class BinarySearch {

    // Work only on sorted arrays and worst case is O(log(n))
    public static int binarySearch(int[] arr, int elementToBeFound){
        int l = 0;
        int r = arr.length - 1;

        while(true){
            if(l > r) return -1;
            int m = (l + r) / 2;
            if(arr[m] == elementToBeFound) return m;
            if(arr[m] < elementToBeFound) l = m + 1;
            if(arr[m] > elementToBeFound) r = m - 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        System.out.println(binarySearch(arr, 53));
    }
}
