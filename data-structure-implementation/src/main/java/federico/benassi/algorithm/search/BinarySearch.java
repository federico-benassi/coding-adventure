package federico.benassi.algorithm.search;

public class BinarySearch<T extends Comparable<T>> implements Search<T>{

    @Override
    public int search(Comparable<T>[] array, T element) {
        int l = 0;
        int r = array.length - 1;

        while(true){
            if(l > r) return -1;
            int m = (l + r) / 2;
            if(array[m].compareTo(element) == 0) return m;
            if(array[m].compareTo(element) < 0) l = m + 1;
            if(array[m].compareTo(element) > 0) r = m - 1;
        }}
}
