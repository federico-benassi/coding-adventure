package federico.benassi.sort_algorithm;

import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] arr){
        if(arr.length <= 1) return arr;
        else{
            var pivot = arr[arr.length / 2];
            var leftArr = quickSort(Arrays.stream(arr).filter(item -> item < pivot).toArray());
            var rightArr = quickSort(Arrays.stream(arr).filter(item -> item > pivot).toArray());

            var finalArr = new int[leftArr.length + 1 + rightArr.length];
            for(int i = 0; i < finalArr.length; i++){
                if(i < leftArr.length){
                    finalArr[i] = leftArr[i];
                } else if(i == leftArr.length){
                    finalArr[i] = pivot;
                } else {
                    finalArr[i] = rightArr[i - leftArr.length - 1];
                }
            }
            return finalArr;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 88, 77, 46, 28, 59, 26, 59, 17, 58};
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i : quickSort(arr))
            sb.append(i).append(", ");

        sb.delete(sb.length() - 2, sb.length()).append("]");

        System.out.println(sb.toString());
    }
}
