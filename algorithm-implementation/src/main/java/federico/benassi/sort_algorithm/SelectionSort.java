package federico.benassi.sort_algorithm;

public class SelectionSort {

    public static int[] selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            int lowestNumber = arr[i];
            int indexOfTheLowestNumber = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < lowestNumber) {
                    lowestNumber = arr[j];
                    indexOfTheLowestNumber = j;
                }
            }
            var temp = arr[i];
            arr[i] = arr[indexOfTheLowestNumber];
            arr[indexOfTheLowestNumber] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 88, 77, 46, 28, 59, 26, 59, 17, 58};
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i : selectionSort(arr))
            sb.append(i).append(", ");

        sb.delete(sb.length() - 2, sb.length()).append("]");

        System.out.println(sb.toString());
    }
}
