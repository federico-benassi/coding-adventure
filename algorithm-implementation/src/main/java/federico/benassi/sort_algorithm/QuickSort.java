package federico.benassi.sort_algorithm;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static federico.benassi.ComparableUtils.exchange;
import static federico.benassi.ComparableUtils.less;

public class QuickSort {

    private static final int CUTOFF = 10;

    public static void quickSort(Comparable[] arr){
        Shuffle.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Comparable[] arr, int lo, int hi){
        if(hi <= lo + CUTOFF - 1) {
            insertionSort(arr, lo, hi);
            return;
        }
        var indexOfPartiotion = partition(arr, lo, hi);
        sort(arr, lo, indexOfPartiotion - 1);
        sort(arr, indexOfPartiotion + 1, hi);
    }

    private static void insertionSort(Comparable[] arr, int lo, int hi){
        for(int i = lo; i < hi; i++){
            for(int j = i; j > lo; j--){
                if(less(arr[j], arr[j - 1])){
                    exchange(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static int partition(Comparable[] arr, int lo, int hi){
        int i = lo, j = hi + 1;
        while(true){
            while(less(arr[++i], arr[lo])){
                if(i == hi) break;
            }
            while(less(arr[lo], arr[--j])){
                if(j == lo) break;
            }
            if( i >= j ) break;
            exchange(arr, i, j);
        }

        exchange(arr, lo, j);
        return j;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = new int[1_000_000];
        for(int i = arr.length; i > 0; i--){
            arr[i - 1] = i;
        }

        // quickSort(arr);
        Arrays.sort(arr);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.txt")));
        for(int i : arr) {
            bw.write("" + i);
            bw.newLine();
        }

        bw.close();
    }
}
