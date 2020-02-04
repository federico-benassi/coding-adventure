package federico.benassi.sort_algorithm;

public class InsertionSort {

    // need to be in place: no support arrays
    public static int[] insertionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            var temp = arr[i];
            for(int j = i - 1; j > -1; j--){
                if(temp < arr[j]){
                    arr[j + 1] = arr[j];
                } else {
                    arr[j + 1] = temp;
                    break;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 88, 77, 46, 28, 59, 26, 59, 17, 58};
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i : insertionSort(arr))
            sb.append(i).append(", ");

        sb.delete(sb.length() - 2, sb.length()).append("]");

        System.out.println(sb.toString());
    }
}
