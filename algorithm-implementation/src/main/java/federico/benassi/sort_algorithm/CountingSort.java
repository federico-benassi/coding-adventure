package federico.benassi.sort_algorithm;

public class CountingSort {


    public static int[] countingSort(int[] arr){
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


        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 88, 77, 46, 28, 59, 26, 59, 17, 58};
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i : countingSort(arr))
            sb.append(i).append(", ");

        sb.delete(sb.length() - 2, sb.length()).append("]");

        System.out.println(sb.toString());
    }
}
