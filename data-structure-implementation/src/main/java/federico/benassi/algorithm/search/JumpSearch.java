package federico.benassi.algorithm.search;

public class JumpSearch<T extends Comparable<T>> implements Search<T>{

    @Override
    public int search(Comparable<T>[] array, T element) {
        int m = (int) Math.sqrt(array.length);

        for(int i = 0; i < array.length; i += m){
            if(array[i].compareTo(element) > 0){
                for(int j = i - m; j < i; j++){
                    if(array[j] == element) return j;
                }
                return -1;
            }
        }

        return -1;
    }
}
