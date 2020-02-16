package federico.benassi;

public class TestUtilities {

    public static final int[] SMALL_INT_UNIQUE_ELEMENTS_ARRAY = new int[10];
    public static final Integer[] SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY = new Integer[10];
    public static final Integer[] MEDIUM_INTEGER_UNIQUE_ELEMENTS_ARRAY = new Integer[10000];
    public static final Integer[] LARGE_INTEGER_UNIQUE_ELEMENTS_ARRAY = new Integer[100000];

    static {
        for(int i = 0; i < SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY.length; i++)
            SMALL_INTEGER_UNIQUE_ELEMENTS_ARRAY[i] = i;
        for(int i = 0; i < MEDIUM_INTEGER_UNIQUE_ELEMENTS_ARRAY.length; i++)
            MEDIUM_INTEGER_UNIQUE_ELEMENTS_ARRAY[i] = i;
        for(int i = 0; i < LARGE_INTEGER_UNIQUE_ELEMENTS_ARRAY.length; i++)
            LARGE_INTEGER_UNIQUE_ELEMENTS_ARRAY[i] = i;
    }

    private TestUtilities(){}

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
