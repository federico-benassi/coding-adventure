package federico.benassi.linear_search;

public class LinearSearch {

    // Worst case is O(n) where n is the length of the array
    public static int linearSearch(int[] arr, int elementToBeFound){
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == elementToBeFound) return i;

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        System.out.println(linearSearch(arr, 53));
    }
}
