package federico.benassi.sort_algorithm;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] arr){
        return mergeSortRecursiveHelper(arr);
    }

    private static int[] mergeSortRecursiveHelper(int[] arr){
        if(arr.length == 0 || arr.length == 1) return arr;


        var firstHalf = Arrays.copyOfRange(arr, 0, arr.length / 2);
        var secondHalf = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        firstHalf = mergeSort(firstHalf);
        secondHalf = mergeSort(secondHalf);

        var firstCounter = 0;
        var secondCounter = 0;
        int[] finalArr = new int[firstHalf.length + secondHalf.length];
        for(int i = 0; i < finalArr.length; i++){
            if(firstCounter == firstHalf.length){
                finalArr[i] = secondHalf[secondCounter];
                secondCounter++;
            } else if (secondCounter == secondHalf.length){
                finalArr[i] = firstHalf[firstCounter];
                firstCounter++;
            } else if(firstCounter < firstHalf.length && firstHalf[firstCounter] > secondHalf[secondCounter]) {
                finalArr[i] = secondHalf[secondCounter];
                secondCounter++;
            }else if(secondCounter < secondHalf.length && secondHalf[secondCounter] >= firstHalf[firstCounter]){
                finalArr[i] = firstHalf[firstCounter];
                firstCounter++;
            }
        }
        return finalArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 88, 77, 46, 28, 59, 26, 59, 17, 58};
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i : mergeSort(arr))
            sb.append(i).append(", ");

        sb.delete(sb.length() - 2, sb.length()).append("]");

        System.out.println(sb.toString());
    }
}
