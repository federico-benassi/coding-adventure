package federico.benassi;

public class TestUtilities {

    private TestUtilities(){}

    public static int[] SMALL_INT_UNIQUE_ELEMENTS_ARRAY = new int[]{9, 7, 5, 3, 1, 8, 6, 4, 2};
    public static Integer[] SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY = new Integer[]{9, 7, 5, 3, 1, 8, 6, 4, 2};

    public static boolean isSorted(Comparable[] arr){
        for(int i = 1; i < arr.length; i++)
            if(arr[i].compareTo(arr[i - 1]) < 0) return false;

        return true;
    }


    public static boolean isSorted(int[] arr) {
        for(int i = 1; i < arr.length; i++)
            if(arr[i] < arr[i - 1]) return false;

        return true;
    }
}
