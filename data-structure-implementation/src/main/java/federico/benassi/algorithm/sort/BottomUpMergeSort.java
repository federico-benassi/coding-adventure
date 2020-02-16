package federico.benassi.algorithm.sort;

public class BottomUpMergeSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(Comparable<T>[] array) {
         Comparable[] aux = new Comparable[array.length];
            for(int size = 1; size < array.length; size += size){
                for(int i = 0; i < array.length - size; i += size + size){
                    Sort.merge(array, aux, i, i + size - 1, Math.min(i + size + size - 1, array.length - 1));
                }
            }

        }
}
