package federico.benassi.search_algorithm;

public class JumpSearch {

    // Work only on sorted arrays and worst case O(n/m)
    public static int jumpSearch(int[] arr, int elementToBeFound){
        int m = (int) Math.sqrt(arr.length);

        for(int i = 0; i < arr.length; i += m){
            if(arr[i] > elementToBeFound){
                for(int j = i - m; j < i; j++){
                    if(arr[j] == elementToBeFound) return j;
                }
                return -1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] arr = new int[1000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        System.out.println(jumpSearch(arr, 53));
    }
}
