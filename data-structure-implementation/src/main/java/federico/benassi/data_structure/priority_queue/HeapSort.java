package federico.benassi.data_structure.priority_queue;

public class HeapSort {
    public static void sort(Comparable[] arr){
        int length = arr.length;
        for(int k = length / 2; k >= 1; k--)
            sink(arr, k, length);
        while (length > 1){
            exchange(arr, 1, length--);
            sink(arr, 1, length);
        }
    }

    private static void sink(Comparable[] arr, int k, int length){
        while(2 * k <= length){
            int j = 2 * k;
            if(j < length && less(arr, j, j + 1)) j++;
            if(!less(arr, k, j)) break;
            exchange(arr, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] arr, int k, int j) {
        return arr[k - 1].compareTo(arr[j - 1]) < 0;
    }

    private static void exchange(Comparable[] arr, int k, int j){
        var temp = arr[k - 1];
        arr[k - 1] = arr[j - 1];
        arr[j - 1] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 8, 2, 0, 43, 38, 2, 92};

        sort(arr);

        for(Integer i : arr){
            System.out.print(i + ", ");
        }
    }
}
