package federico.benassi;

public class ComparableUtils {
    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static boolean lessOrEqual(Comparable a, Comparable b){
        if(a.compareTo(b) <= 0) return true;
        else return false;
    }

    public static void exchange(Comparable[] comparables, int aIndex, int bIndex){
        var temp = comparables[aIndex];
        comparables[aIndex] = comparables[bIndex];
        comparables[bIndex] = temp;
    }
}
