package federico.benassi.algorithm.sort;

public class BubbleSort {

    public static Comparable[] bubbleSort(Comparable[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
