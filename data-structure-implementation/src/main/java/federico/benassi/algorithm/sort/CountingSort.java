package federico.benassi.algorithm.sort;

// Works only with integers
public class CountingSort {

    public static void countingSort(int[] arr){
        int max = arr[0];
        int min = arr[0];

        for(int i : arr){
            if(i > max) max = i;
            if(i < min) min = i;
        }

        int[] c = new int[max - min + 1];
        for(int i : arr){
            c[i - min]++;
        }

        int k = 0;
        for(int i = 0; i < c.length; i++){
            while(c[i] > 0){
                arr[k] = i + min;
                k++;
                c[i]--;
            }
        }
    }
}
